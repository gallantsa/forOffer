package 单例;

/**
 * 加锁懒汉式单例，线程安全
 */
public class LanHanWithLockSingleInstance {

    //懒汉式：初始化时不创建实例，等需要时再创建
    private static LanHanWithLockSingleInstance instance;

    private LanHanWithLockSingleInstance() {
        doSomething();
    }

    public static synchronized LanHanWithLockSingleInstance getInstance() {
        //先判断是否为空，若为空创建一个新的实例
        if (instance == null) {
            instance = new LanHanWithLockSingleInstance();
        }

        return instance;
    }

    public void doSomething() {

    }
}
