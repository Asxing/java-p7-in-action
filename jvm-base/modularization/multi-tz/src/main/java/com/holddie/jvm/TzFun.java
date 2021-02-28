package com.holddie.jvm;

import com.holddie.jvm.sdk.IFun;

public class TzFun implements IFun {
    @Override
    public void sayHello(String name) {
        System.out.println("Hi " + name + ", i am TzFun");
    }
}
