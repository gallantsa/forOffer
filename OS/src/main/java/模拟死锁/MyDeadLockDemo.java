package 模拟死锁;

public class MyDeadLockDemo {
    // 资源1
    private static Object resource1 = new Object();
    // 资源2
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("获取了资源1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("准备获取资源2");
                synchronized (resource2) {
                    System.out.println("获取了资源2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println("获取了资源2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("准备获取资源1");
                synchronized (resource1) {
                    System.out.println("获取了资源1");
                }
            }
        }).start();
    }
}
