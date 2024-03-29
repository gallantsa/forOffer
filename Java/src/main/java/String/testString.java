package String;

public class testString {
    public static void main(String[] args) {
        // private final byte[] value; 底层是不可变数组
        // String s = new String("123");

        // 继承AbstractStringBuilder
        // 底层用的是可变数组 byte[] value;
        /*public StringBuilder() {
            super(16);
        }*/
        // 默认长度16
//        StringBuilder sb = new StringBuilder();
//        sb.append("123"); // 也是父类中的方法

//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("123"); // 也继承AbstractStringBuilder, 关键方法有synchronized
        String str1 = "123";
        String str2 = new String("123");
        String str3 = str2;
        System.out.println("str1 == str2：" + (str1 == str2)); // false
        System.out.println("str1 == str3：" + (str1 == str3)); // false
        System.out.println("str2 == str3：" + (str2 == str3)); // true

        //通过java.lang.String.intern()方法指定字符串对象
        String str4 = str2.intern();
        System.out.println("str1 == str4：" + (str1 == str4)); // true
        System.out.println("str2 == str4：" + (str2 == str4)); // false

        String s1 = new StringBuilder().append("ja").append("va1").toString();
        System.out.println(s1.intern() == s1); // true

        String s2 = "java1"; // 回字符串池中对象引用
        System.out.println(s2 == s1); // true

        String s3 = "ja" + "va1";
        System.out.println(s2 == s3); // true

        String s4 = "jav" + "a1";
        System.out.println(s3 == s4); // true

        String s5 = "jav";
        String s6 = "a1";
        String s7 = s5 + s6;
        System.out.println(s7 == s4); // false
    }
}
