package 虚拟线程;

public class VirtualThreadExample {
    public static void main(String[] args) {
        // 创建并启动一个虚拟线程
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            System.out.println("mianshiya.com virtual thread: " + Thread.currentThread());
        });

        // 等待虚拟线程完成
        try {
            virtualThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
