package 多线程并发打印奇数和偶数;

public class MyPrintOddEven {

    // 打印数字上限
    private static final int INT_MAX = 100;
    // 计数
    private static int count = 0;
    // 锁对象
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        // 打印偶数线程
        new Thread(() -> {
            while (count <= INT_MAX) {
                synchronized (LOCK) {
                    if (count % 2 == 0) {
                        System.out.println(count++);
                    }
                }
            }
        }).start();

        // 打印奇数线程
        new Thread(() -> {
            while (count <= INT_MAX) {
                synchronized (LOCK) {
                    if (count % 2 == 1) {
                        System.out.println(count++);
                    }
                }
            }
        }).start();
    }
}
