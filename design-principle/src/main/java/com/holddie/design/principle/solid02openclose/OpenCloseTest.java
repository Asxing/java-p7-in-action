package com.holddie.design.principle.solid02openclose;

/**
 * Created by Tom.
 */
public class OpenCloseTest {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(232, "Java架构师专题课", 11800D);
        JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;
        System.out.println("课程ID:" + javaCourse.getId() +
                "\n课程名称:《" + javaCourse.getName() + "》" +
                "\n原价:" + javaCourse.getPrice()  + "元" +
                "\n折后价:" + javaCourse.getDiscountPrice() + "元");

        ICourse iCourse1 = new JavaDiscountCourse(232, "Java架构师专题课", 11800D);
        JavaDiscountCourse javaCourse1 = (JavaDiscountCourse) iCourse1;
        System.out.println("课程ID:" + javaCourse1.getId() +
                "\n课程名称:《" + javaCourse1.getName() + "》" +
                "\n折后价:" + javaCourse1.getPrice() + "元");
    }
}
