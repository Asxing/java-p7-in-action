package com.holddie.design.principle.solid03liskovsubstitution.methodreturn;

/** Created by Tom */
public class MethodReturnTest {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.method());
    }
}
