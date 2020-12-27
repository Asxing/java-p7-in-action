package com.holddie.design.principle.solid04lawofdemeter;

/** Created by Tom */
public class Boss {

    //    public void commandCheckNumber(TeamLeader teamLeader){
    //        //模拟Boss一页一页往下翻页，TeamLeader实时统计
    //        List<Course> courseList = new ArrayList<Course>();
    //        for (int i= 0; i < 20 ;i ++){
    //            courseList.add(new Course());
    //        }
    //        teamLeader.checkNumberOfCourses(courseList);
    //    }

    public void commandCheckNumber(TeamLeader teamLeader) {
        teamLeader.checkNumberOfCourses();
    }
}
