package 单例;

/**
 * 无锁懒汉式单例，非线程安全
 */
public class LanHanNoLockSingleInstance {

    //懒汉式：初始化时不创建实例，等需要时再创建
    private static LanHanNoLockSingleInstance instance;

    private LanHanNoLockSingleInstance() {
        doSomething();
    }

    public static LanHanNoLockSingleInstance getInstance() {
        //先判断是否为空，若为空创建一个新的实例
        if (instance == null) {
            instance = new LanHanNoLockSingleInstance();
        }

        return instance;
    }

    public void doSomething() {

    }
}
