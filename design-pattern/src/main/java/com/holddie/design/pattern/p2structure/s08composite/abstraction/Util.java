package com.holddie.design.pattern.p2structure.s08composite.abstraction;


import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.IEmployee;
import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.Subscription;
import com.holddie.design.pattern.p2structure.s08composite.abstraction.abstraction.SubscriptionType;

/**
 * 工具辅助类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 9:56
 */
public class Util {

    public static void printCostDetails(IEmployee employee) {
        double cost = employee.getCost();
        int licenseSubCount = employee.getSubscriptionCount(SubscriptionType.SOFTWARE_LICENSE);
        int printSubCount = employee.getSubscriptionCount(SubscriptionType.PRINT);
        int trainingSubCount = employee.getSubscriptionCount(SubscriptionType.TRAINING);
        String outMsg = "Cost: %f, Count License: %d, Count Print: %d, Count Training: %d, Emp ID: %d\n";
        System.out.print(String.format(outMsg, cost, licenseSubCount, printSubCount, trainingSubCount, employee.getEmployeeId()));
    }

    public static Subscription getIntellijSubscription() {
        Subscription sub = new Subscription();
        sub.setCost(30);
        sub.setName("Intellij License");
        sub.setSType(SubscriptionType.SOFTWARE_LICENSE);
        return sub;
    }

    public static Subscription getJProfilierSubscription() {
        Subscription sub = new Subscription();
        sub.setCost(20);
        sub.setName("JProfilier License");
        sub.setSType(SubscriptionType.SOFTWARE_LICENSE);
        return sub;
    }

    public static Subscription getCSDNSubscription() {
        Subscription sub = new Subscription();
        sub.setName("CSDN Magazine");
        sub.setSType(SubscriptionType.PRINT);
        sub.setCost(10);
        return sub;
    }

    public static Subscription getTrainingSubscription() {
        Subscription sub = new Subscription();
        sub.setName("Java Design Pattern");
        sub.setSType(SubscriptionType.TRAINING);
        sub.setCost(300);
        return sub;
    }

}
