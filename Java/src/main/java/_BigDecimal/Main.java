package _BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        // 演示浮点数精度问题
        // test1();

        // 演示BigDecimal计算浮点数(阿里Java规范推荐使用入参为String的构造方法, 而不是使用入参为浮点数的构造方法)
        // test2();

        // 演示BigDecimal的加减乘除
        // test3();

        // 演示大小比较
        // test4();

        // 演示保留几位小数
        // test5();

        // 演示等值比较问题(阿里Jvaa规范中推荐使用compareTo进行等值比较, equals比较时会考虑精度问题, 而compareTo不会考虑)
        // test6();
    }

    private static void test6() {
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1.0");
        System.out.println(a.equals(b));//false
        System.out.println(a.compareTo(b));//0
    }

    private static void test5() {
        BigDecimal m = new BigDecimal("1.255433");
        BigDecimal n = m.setScale(3, RoundingMode.HALF_DOWN);
        System.out.println(n);// 1.255
    }

    private static void test4() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        System.out.println(a.compareTo(b));// 1
    }

    private static void test3() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        System.out.println(a.add(b));// 1.9
        System.out.println(a.subtract(b));// 0.1
        System.out.println(a.multiply(b));// 0.90
        // System.out.println(a.divide(b));// 无法除尽，抛出 ArithmeticException 异常
        System.out.println(a.divide(b, 2, RoundingMode.HALF_UP));// 1.11
    }

    private static void test2() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        System.out.println(x.compareTo(y));// 0
    }

    private static void test1() {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);// 0.100000024
        System.out.println(b);// 0.099999905
        System.out.println(a == b);// false
    }
}


