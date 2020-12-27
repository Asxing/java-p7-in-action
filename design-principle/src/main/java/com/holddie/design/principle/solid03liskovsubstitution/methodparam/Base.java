package com.holddie.design.principle.solid03liskovsubstitution.methodparam;

import java.util.HashMap;

/**
 * Created by Tom
 */
public class Base {
    public void method(HashMap map){
        System.out.println("父类被执行");
    }
}
