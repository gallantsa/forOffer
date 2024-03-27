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
    }
}
