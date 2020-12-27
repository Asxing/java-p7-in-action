package com.holddie.design.principle.solid01singletonresponsibility.interfaced;
/**
 * Created by Tom
 */
public class CourseImpl implements ICourseManager,ICourseInfo {
    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }

    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVideo() {
        return new byte[0];
    }
}
