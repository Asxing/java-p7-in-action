package com.holddie.design.pattern.p2structure.s10facade.business;

/**
 * 支付接口
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 9:56
 */
public interface IPaymentGateway {
    public boolean verifyCardDetails(String cardNo);

    public boolean processPayment(String cardNo, float cost);
}
