package 单例;

/**
 * 双检锁单例
 */
public class DoubleCheckSingleInstance {

    //使用volatile保证多线程的可见性
    private static volatile DoubleCheckSingleInstance instance;

    private DoubleCheckSingleInstance() {
        doSomething();
    }

    public static DoubleCheckSingleInstance getInstance() {
        //第一次检查是否创建过该单例
        if (instance == null) {
            //加锁，保证线程安全
            synchronized (DoubleCheckSingleInstance.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleInstance();
                }
            }
        }
        return instance;
    }

    public void doSomething() {

    }
}
