package asynchronous;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000); // 模拟耗时操作
            return 42;
        });

        // 在任务完成后执行回调函数
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Integer result = future.get(); // 获取任务结果
                    System.out.println("Thread:" + Thread.currentThread().getName() + "-Async task result: " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("Main thread continues to do other tasks...");

        // 关闭线程池
        executor.shutdown();
    }
}
