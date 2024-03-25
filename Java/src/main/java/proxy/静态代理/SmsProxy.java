package proxy.静态代理;

public class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    // 静态代理缺点:
    // 接口一旦新增加方法，目标对象和代理对象都要进行修改
    // 需要对每个目标类都单独写一个代理类
    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }
}
