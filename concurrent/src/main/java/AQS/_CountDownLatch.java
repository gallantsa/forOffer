package AQS;

import java.util.concurrent.CountDownLatch;

public class _CountDownLatch {
    public static void main(String[] args) {
        // 创建CountDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(2);
        // 创建线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "执行完毕");
                // 计数器减1
                countDownLatch.countDown();
            }).start();
        }
        try {
            // 等待计数器归零
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程执行完毕");
    }
}
