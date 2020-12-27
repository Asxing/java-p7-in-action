package com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction;

import java.util.List;

/**
 * 员工抽象
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 9:09
 */
public interface IEmployee {

    public String getName();

    public void setName(String name);

    public int getEmployeeId();

    public void setEmployeeId(int employeeId);

    public List<Subscription> getSubscriptions();

    public void setSubscriptions(List<Subscription> subscriptions);

    public double getCost();

    public int getSubscriptionCount(SubscriptionType type);
}
