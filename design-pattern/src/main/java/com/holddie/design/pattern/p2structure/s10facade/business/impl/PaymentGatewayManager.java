package com.holddie.design.pattern.p2structure.s10facade.business.impl;


import com.holddie.design.pattern.p2structure.s10facade.business.IPaymentGateway;

/**
 * 支付实现
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 10:02
 */
public class PaymentGatewayManager implements IPaymentGateway {
    @Override
    public boolean verifyCardDetails(String cardNo) {
        return false;
    }

    @Override
    public boolean processPayment(String cardNo, float cost) {
        return false;
    }
}
