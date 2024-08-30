package 检测线程池内部任务异常;

import java.util.concurrent.ThreadFactory;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2024年08月30日 13:42
 */
public class 使用ThreadFactory和UncaughtExceptionHandler {
    public class CustomThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler((t, e) -> {
                System.out.println("面试鸭Thread " + t.getName() + " threw exception: " + e);
            });
            return thread;
        }
    }
}
