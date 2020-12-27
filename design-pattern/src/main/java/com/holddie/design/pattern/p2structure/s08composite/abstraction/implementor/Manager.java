package com.holddie.design.pattern.p2structure.s08composite.abstraction.implementor;

import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.IEmployee;
import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.Subscription;
import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.SubscriptionType;
import lombok.Data;

import java.util.List;

/**
 * Boss
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 9:17
 */
@Data
public class Manager extends BaseEmployee {

    private List<IEmployee> teamMembers;

    public Manager(
            String name,
            int employeeId,
            List<Subscription> subscriptions,
            List<IEmployee> teamMembers) {
        this.name = name;
        this.employeeId = employeeId;
        this.subscriptions = subscriptions;
        this.teamMembers = teamMembers;
    }

    @Override
    public double getCost() {
        double subsCost = 0.0;
        if (subscriptions != null) {
            subsCost = subscriptions.stream().mapToDouble(Subscription::getCost).sum();
        }
        double membercost = 0.0;
        if (teamMembers != null) {
            membercost = teamMembers.stream().mapToDouble(IEmployee::getCost).sum();
        }
        return subsCost + membercost;
    }

    @Override
    public int getSubscriptionCount(SubscriptionType type) {
        int subCount = 0;
        if (subscriptions != null) {
            subCount = (int) subscriptions.stream().filter(s -> s.getSType() == type).count();
        }

        int memberCount = 0;
        if (teamMembers != null) {
            for (IEmployee member : teamMembers) {
                List<Subscription> subs = member.getSubscriptions();
                if (subs != null) {
                    for (Subscription sub : subs) {
                        if (sub.getSType() == type) {
                            memberCount++;
                        }
                    }
                }
            }
        }
        return subCount + memberCount;
    }
}
