package com.holddie.design.pattern.p2structure.s08composite.abstraction.implementor;


import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.Subscription;
import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.SubscriptionType;

/**
 * 开发
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 9:12
 */
public class Developer extends BaseEmployee {


    public Developer(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    @Override
    public double getCost() {
        if (subscriptions == null) {
            return 0;
        }
        return subscriptions.stream().mapToDouble(Subscription::getCost).sum();
    }

    @Override
    public int getSubscriptionCount(SubscriptionType type) {
        if (subscriptions == null) {
            return 0;
        }
        return (int) subscriptions.stream().filter(subscription -> subscription.getSType() == type).count();
    }
}
