package 多线程并发打印奇数和偶数;

public class PrintOddEven {
    private static final int MAX_NUM = 10;
    private static volatile int count = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            while (count <= MAX_NUM) {
                synchronized (lock) {
                    if (count % 2 == 1) {
                        System.out.println("Odd: " + count);
                        count++;
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (count <= MAX_NUM) {
                synchronized (lock) {
                    if (count % 2 == 0) {
                        System.out.println("Even: " + count);
                        count++;
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
