package com.holddie.design.pattern.p2structure.s10facade.business;

/**
 * 费用计算接口
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 9:51
 */
public interface ICosting {

    public float applyDiscount(float price, float discountPercent);

}
