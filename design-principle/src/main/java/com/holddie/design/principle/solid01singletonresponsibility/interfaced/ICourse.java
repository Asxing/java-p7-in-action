package com.holddie.design.principle.solid01singletonresponsibility.interfaced;

/** Created by Tom */
public interface ICourse {

    // 获得基本信息
    String getCourseName();

    // 获得视频流
    byte[] getCourseVideo();

    // 学习课程
    void studyCourse();
    // 退款
    void refundCourse();
}
