package 线程池;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;


@Slf4j
public class AsyncFileReadWriteExample {

    public static void main(String[] args) {
        String filePath = "concurrent/src/main/resources/test.txt";
        log.info("start.");
        // 异步读取文件
        CompletableFuture<Void> readFuture = CompletableFuture.runAsync(() -> {
            try {
                Path path = Paths.get(filePath);
                String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                log.info("Read from file: {}", content);
                log.info("read done.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 异步写入文件
        CompletableFuture<Void> writeFuture = CompletableFuture.runAsync(() -> {
            try {
                Path path = Paths.get(filePath);
                String content = "Hello, World!";
                Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                log.info("Write to file: {}", content);
                log.info("write done.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 等待读取和写入完成
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(readFuture, writeFuture);
        allFutures.join();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("all done.");
    }
}

