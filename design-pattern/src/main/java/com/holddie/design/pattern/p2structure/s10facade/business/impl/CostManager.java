package com.holddie.design.pattern.p2structure.s10facade.business.impl;

import com.holddie.design.pattern.p2structure.s10facade.business.ICosting;

/**
 * 费用计算实现类
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/31 9:52
 */
public class CostManager implements ICosting {
    @Override
    public float applyDiscount(float price, float discountPercent) {
        return 0;
    }
}
