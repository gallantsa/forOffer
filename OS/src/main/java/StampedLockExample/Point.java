package StampedLockExample;

import java.util.concurrent.locks.StampedLock;

class Point {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    void move(double deltaX, double deltaY) { // an exclusively locked method
        long stamp = sl.writeLock();  //获取写锁
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp); //释放写锁
        }
    }

    double distanceFromOrigin() { // A read-only method
        long stamp = sl.tryOptimisticRead(); //乐观读
        double currentX = x, currentY = y;
        if (!sl.validate(stamp)) { //判断共享变量是否已经被其他线程写过
            stamp = sl.readLock();  //如果被写过则升级为悲观读锁
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp); //释放悲观读锁
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    void moveIfAtOrigin(double newX, double newY) { // upgrade
        // Could instead start with optimistic, not read mode
        long stamp = sl.readLock(); //获取读锁
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = sl.tryConvertToWriteLock(stamp);  //升级为写锁
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }

    public static void main(String[] args) {
        // 测试StampedLock
        Point point = new Point();
        point.move(Math.sqrt(2), Math.sqrt(2));
        System.out.println(point.distanceFromOrigin());
    }
}

