package com.example;

import java.util.ServiceLoader;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2025年02月19日 9:13
 */
public class test {
    public static void main(String[] args) {
        ServiceLoader<MyService> serviceLoader = ServiceLoader.load(MyService.class);
        for (MyService service : serviceLoader) {
            service.execute();
        }
    }
}
