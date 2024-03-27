package 单例;

/**
 * 静态内部类单例
 */
public class StaticInternalSingleInstance {

    //静态内部类
    private static class StaticInternalSingleInstanceHolder{

        private static final StaticInternalSingleInstance INSTANCE
                = new StaticInternalSingleInstance();

    }

    private StaticInternalSingleInstance() {
        doSomething();
    }

    public static final StaticInternalSingleInstance getInstance() {
        return StaticInternalSingleInstanceHolder.INSTANCE;
    }

    public void doSomething() {

    }

}
