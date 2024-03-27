package 单例;

/**
 * 枚举型单例
 */
public enum EnumSingleInstance {

    INSTANCE;

    public EnumSingleInstance getInstance(){
        return INSTANCE;
    }
}
