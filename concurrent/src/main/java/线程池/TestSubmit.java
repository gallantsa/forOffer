package 线程池;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class TestSubmit {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        // 测试submit方法, 并获取返回值
        // testSubmit1();

        // 测试submit方法, 并设置超时时间
        // testSubmit2();
    }

    private static void testSubmit2() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> submit = executorService.submit(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

        String s = submit.get(3, TimeUnit.SECONDS);
        System.out.println(s);
        executorService.shutdown();
    }

    private static void testSubmit1() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> submit = executorService.submit(() -> {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

        String s = submit.get();
        System.out.println(s);
        executorService.shutdown();
    }
}
