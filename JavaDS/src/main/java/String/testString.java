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
    }
}
