package 单例;

/**
 * 饿汉式单例
 */
public class EHanSingleInstance {

    //饿汉式：初始化时就建好实例
    private static final EHanSingleInstance instance = new EHanSingleInstance();

    private EHanSingleInstance() {
        doSomething();
    }

    public static EHanSingleInstance getInstance() {
        return instance;
    }

    public void doSomething() {

    }
}
