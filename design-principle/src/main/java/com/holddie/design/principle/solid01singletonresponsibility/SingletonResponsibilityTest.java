package com.holddie.design.principle.solid01singletonresponsibility;

import com.holddie.design.principle.solid01singletonresponsibility.simple.Course;
import com.holddie.design.principle.solid01singletonresponsibility.simple.LiveCourse;
import com.holddie.design.principle.solid01singletonresponsibility.simple.ReplayCourse;

/** Created by Tom. */
public class SingletonResponsibilityTest {
    public static void main(String[] args) {
        Course course = new Course();
        course.study("直播课");
        course.study("录播课");

        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study("直播课");

        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");
    }
}
