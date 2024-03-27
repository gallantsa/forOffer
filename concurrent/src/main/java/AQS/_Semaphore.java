package AQS;

import java.util.concurrent.Semaphore;

public class _Semaphore {
    public static void main(String[] args) {
        // 创建Semaphore
        Semaphore semaphore = new Semaphore(2);
        // 创建线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    // 获取许可
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获取许可");
                    // 模拟耗时操作
                    Thread.sleep(1000);
                    // 释放许可
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放许可");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
