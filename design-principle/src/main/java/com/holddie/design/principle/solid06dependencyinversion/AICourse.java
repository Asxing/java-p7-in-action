package com.holddie.design.principle.solid06dependencyinversion;

/** Created by Tom */
public class AICourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Tom在学习AI课程");
    }
}
