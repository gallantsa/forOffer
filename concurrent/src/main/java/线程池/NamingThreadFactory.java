package 线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工厂，它设置线程名称，有利于我们定位问题。
 */
public final class NamingThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNum = new AtomicInteger();
    private final String name;

    /**
     * 创建一个带名字的线程池生产工厂
     */
    public NamingThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName(name + " [#" + threadNum.incrementAndGet() + "]");
        return t;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor test = new ThreadPoolExecutor(2, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(4), new NamingThreadFactory("test"), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            test.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
