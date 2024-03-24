package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
    void sayHello();
}

class HelloImpl implements Hello {
    public void sayHello() {
        System.out.println("Hello, world!");
    }
}

class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method invocation");
        Object result = method.invoke(target, args);
        System.out.println("After method invocation");
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        Hello proxy = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Hello.class},
                new DynamicProxy(hello)
        );
        proxy.sayHello();
    }
}
