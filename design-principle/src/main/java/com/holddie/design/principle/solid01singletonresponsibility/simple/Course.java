package com.holddie.design.principle.solid01singletonresponsibility.simple;

/** Created by Tom. */
public class Course {

    public void study(String courseName) {
        if ("直播课".equals(courseName)) {
            System.out.println(courseName + "不能快进");
        } else {
            System.out.println(courseName + "可以反复回看");
        }
    }
}
