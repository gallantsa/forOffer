package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2024年08月30日 22:29
 */
public class Main {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (true) {
                throw new RuntimeException("Exception");
            }
            return "Hello";
        }).exceptionally(ex -> "面试鸭");

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Exception");
            }
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                return "Default Value";
            }
            return result;
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);
        allFutures.thenRun(() -> System.out.println("面试鸭 tasks finished"));


        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(future1, future2);
        anyFuture.thenAccept(result -> System.out.println("面试鸭 task finished with result: " + result));

        // 由于异步任务需要时间，所以这里需要等待异步任务执行完成, 否则看不到输出结果
        // 如果不等待，可以使用join()方法，join()方法会阻塞当前线程直到异步任务执行完成

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void test4() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Exception");
            }
            return "Hello";
        }).exceptionally(ex -> "面试鸭");
        System.out.println(future1.join());

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Exception");
            }
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                return "Default Value";
            }
            return result;
        });
        System.out.println(future2.join());
    }

    private static void test3() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "面试鸭");

        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> result1 + " " + result2);
        System.out.println(combinedFuture.join());
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> result + " 面试鸭"));
        System.out.println(future.join());
    }

    private static void test2() {
        // 转换任务结果
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(result -> result + " mianshiya.com").thenApply(String::toUpperCase);
        System.out.println(future1.join());

        // 消费任务结果，不返回新结果
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(result -> System.out.println(result));

        // 不消费任务结果，也不返回新结果
        CompletableFuture<Void> future3 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenRun(() -> System.out.println("Task finished"));
    }

    private static void test1() {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            // 异步任务
            System.out.println("Hello, mianshiya1.com!");
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            // 异步任务并返回结果
            return "Hello, mianshiya2.com!";
        });

        future1.join();
        System.out.println(future2.join());
    }
}
