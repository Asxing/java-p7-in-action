package com.holddie.design.pattern.p2structure.s10facade.business;

/**
 * 物流接口
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 9:55
 */
public interface ILogistics {
    public void shipProducts(String productName, String shippingAddress);
}
