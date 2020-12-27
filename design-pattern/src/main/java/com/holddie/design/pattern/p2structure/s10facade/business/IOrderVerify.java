package com.holddie.design.pattern.p2structure.s10facade.business;

/**
 * 订单校验接口
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 9:55
 */
public interface IOrderVerify {
    public boolean verifyShippingAddress(int pinconde);
}
