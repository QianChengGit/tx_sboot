package cn.tx.service.impl;

import cn.tx.service.PayService;

public class WxPay  implements PayService {
    @Override
    public void pay() {
        System.out.println("微信支付！");
    }
}
