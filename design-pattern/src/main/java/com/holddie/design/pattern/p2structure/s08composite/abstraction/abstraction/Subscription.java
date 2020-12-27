package com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction;

import lombok.Data;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 9:30
 */
@Data
public class Subscription {

    // 订购类型
    private SubscriptionType sType;

    private String name;

    private double cost;

}
