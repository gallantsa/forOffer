package 线程池;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

@Slf4j
public class ThreadPoolStatus {
    static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    static ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        // 创建一个线程池

        // 向线程池提交任务
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task" + finalI + " completed");
            });
        }


        // 打印线程池状态
        printThreadPoolStatus(threadPool);

        // 关闭线程池
        threadPool.shutdown();

        try {
            // 等待线程池关闭，最多等待5分钟
            if (!threadPool.awaitTermination(5, TimeUnit.MINUTES)) {
                // 如果等待超时，则打印日志
                System.err.println("线程池未能在5分钟内完全关闭");
            } else {
                System.out.println("线程池已经完全关闭");
                scheduledExecutorService.shutdown();
                System.out.println("监控线程池状态的任务也关闭了");
            }
        } catch (InterruptedException e) {
            // 异常处理
            System.err.println("等待线程池关闭时发生异常");
        }
    }


    /**
     * 打印线程池的状态信息
     *
     * @param threadPool 线程池对象
     */
    public static void printThreadPoolStatus(ThreadPoolExecutor threadPool) {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.print("\r"); // 回车，将光标移动到行首
            System.out.print("=========================");
            System.out.print("\r"); // 回车，将光标移动到行首
            System.out.print("ThreadPool Size: " + threadPool.getPoolSize() + " ");
            System.out.print("Active Threads: " + threadPool.getActiveCount() + " ");
            System.out.print("Completed Tasks: " + threadPool.getCompletedTaskCount() + " ");
            System.out.print("Number of Tasks in Queue: " + threadPool.getQueue().size() + " ");
            System.out.print("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }

}
