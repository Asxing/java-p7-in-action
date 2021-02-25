package com.holddie.jvm.classloader.v4;

public class Foo implements IFoo {

    @Override
    public void SetState(String state) {
        System.out.println("Foo SetState");
    }

    @Override
    public void sayHello() {
        System.out.println("Foo sayHello");
    }
}
