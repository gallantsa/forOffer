package proxy.CGLIB动态代理;

import net.sf.cglib.proxy.Enhancer;

public class CglibProxyFactory {

    //JDK 动态代理有一个最致命的问题是其只能代理实现了接口的类。
    //为了解决这个问题，我们可以用 CGLIB 动态代理机制来避免。
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
