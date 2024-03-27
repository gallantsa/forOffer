package AQS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class _CompletableFuture {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    private static void test2() {
        //文件夹位置
        List<String> filePaths = Arrays.asList("1", "2", "3", "4", "5", "6");
        // 异步处理所有文件
        List<CompletableFuture<String>> fileFutures = filePaths.stream()
                .map(filePath -> CompletableFuture.supplyAsync(() -> {
                    //处理文件的业务操作
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("ThreadName:" + Thread.currentThread().getName() + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    System.out.println("filePath:" + filePath);
                    return filePath;
                }))
                .collect(Collectors.toList());
        // 将他们合并起来
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                fileFutures.toArray(new CompletableFuture[fileFutures.size()])
        );
        allFutures.join();
        System.out.println("all done. ");
    }

    private static void test1() {
        CompletableFuture<Void> task1 =
                CompletableFuture.supplyAsync(() -> {
                    //自定义业务操作
                    System.out.println("task1");
                    return null;
                });

        CompletableFuture<Void> task2 =
                CompletableFuture.supplyAsync(() -> {
                    //自定义业务操作
                    System.out.println("task2");
                    return null;
                });


        CompletableFuture<Void> task3 =
                CompletableFuture.supplyAsync(() -> {
                    //自定义业务操作
                    System.out.println("task3");
                    return null;
                });

        CompletableFuture<Void> task4 =
                CompletableFuture.supplyAsync(() -> {
                    //自定义业务操作
                    System.out.println("task4");
                    return null;
                });


        CompletableFuture<Void> task5 =
                CompletableFuture.supplyAsync(() -> {
                    //自定义业务操作
                    System.out.println("task5");
                    return null;
                });

        CompletableFuture<Void> task6 =
                CompletableFuture.supplyAsync(() -> {
                    //自定义业务操作
                    System.out.println("task6");
                    return null;
                });

        CompletableFuture<Void> headerFuture = CompletableFuture.allOf(task1, task2, task3, task4, task5, task6);

        try {
            headerFuture.join();
        } catch (Exception ex) {
            System.err.println("error");
        }
        System.out.println("all done. ");
    }
}
