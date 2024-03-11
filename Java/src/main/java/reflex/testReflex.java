package reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class testReflex {
    public static void main(String[] args) throws Exception {
        // 获取类的 Class 对象
            Class<?> clazz = Class.forName("reflex.Dog");

            // 获取私有属性
            Field field = clazz.getDeclaredField("name");

            // 允许访问私有属性
            field.setAccessible(true);

            // 创建实例
            Object obj = clazz.getDeclaredConstructor().newInstance();

            // 设置私有属性的值
            field.set(obj, "Buddy");

            // 获取私有方法
            Method method = clazz.getDeclaredMethod("bark");

            // 允许访问私有方法
            method.setAccessible(true);

            // 调用私有方法
            method.invoke(obj);

            // 打印私有属性的值
            System.out.println(field.get(obj));
    }
}

class Dog {
    private String name;

    private void bark() {
        System.out.println("Woof! Woof!");
    }
}