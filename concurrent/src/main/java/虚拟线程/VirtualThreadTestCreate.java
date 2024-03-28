package 虚拟线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

// 创建虚拟线程
public class VirtualThreadTestCreate {
    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();
        test4();
    }

    private static void test4() {
        CustomThread customThread = new CustomThread();
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(customThread);
    }

    // 使用 ThreadFactory 创建
    private static void test3() {
        CustomThread customThread = new CustomThread();
        ThreadFactory factory = Thread.ofVirtual().factory();
        Thread thread = factory.newThread(customThread);
        thread.start();
    }

    // 使用 Thread.ofVirtual()创建
    private static void test2() {
        CustomThread customThread = new CustomThread();
        // 创建不启动
        Thread unStarted = Thread.ofVirtual().unstarted(customThread);
        unStarted.start();
        // 创建直接启动
        Thread.ofVirtual().start(customThread);
    }

    // 使用 Thread.startVirtualThread()创建
    private static void test1() {
        CustomThread customThread = new CustomThread();
        Thread.startVirtualThread(customThread);
    }
}

class CustomThread implements Runnable {
    @Override
    public void run() {
        System.out.println("CustomThread run");
    }
}
