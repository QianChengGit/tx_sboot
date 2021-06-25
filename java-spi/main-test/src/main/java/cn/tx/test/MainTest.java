package cn.tx.test;
import cn.tx.service.PayService;
import java.util.ServiceLoader;

public class MainTest {
    public static void main(String[] args) {
        //java的spi思想，根据接口自动发现接口实现类，解耦合。
        ServiceLoader<PayService> load = ServiceLoader.load(PayService.class);
        for (PayService pay: load) {
            pay.pay();
        }
    }
}
