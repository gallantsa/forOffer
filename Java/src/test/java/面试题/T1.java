package 面试题;

abstract class DataHandle {
    public String name;

    public void handle() {
        System.out.println("通用日志处理");
        _handle();
    }

    public void _handle() {

    }
}

class LoginDataHandle extends DataHandle {
    public String name;

    public void _handle() {
        System.out.println("登录日志数据处理");
    }

    public void handle(boolean toMq) {
        if (toMq) {
            System.out.println("发送消息到mq中");
        }
        handle();
    }
}


public class T1 {
    public static void main(String[] args) {
        LoginDataHandle a = new LoginDataHandle();
        a.name = "LoginDataHandle";
        DataHandle b = a;
        b.name = "DataHandle";
        System.out.println(a.name);
        System.out.println(b.name);

        a.handle();
        b.handle();
        a.handle(true);
    }
}
