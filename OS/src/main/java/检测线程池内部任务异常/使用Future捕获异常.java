package 检测线程池内部任务异常;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2024年08月30日 13:43
 */
public class 使用Future捕获异常 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<?> future = executor.submit(() -> {
            throw new RuntimeException("Exception in thread");
        });

        try {
            future.get(); // 可以获取报错
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task threw exception: " + e.getCause());
        }

        executor.shutdown();
    }
}
