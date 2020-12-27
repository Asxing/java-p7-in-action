package com.holddie.design.pattern.p3behavior.visitor.singleDispatch;

public class SingleDispatchClass {
    public void polymorphismFunction(ParentClass p) {
        p.f();
    }

    public void overloadFunction(ParentClass p) {
        System.out.println("I am overloadFunction(ParentClass p).");
        p.f();
    }

    public void overloadFunction(ChildClass c) {
        System.out.println("I am overloadFunction(ChildClass c).");
        c.f();
    }

    public static void main(String[] args) {
        SingleDispatchClass singleDispatchClass = new SingleDispatchClass();
        ParentClass p = new ChildClass();
        // 执行那个对象的方法，由对象的实际类型决定
        singleDispatchClass.polymorphismFunction(p);
        // 执行对象的那个方法，由参数对象的声明类型决定
        singleDispatchClass.overloadFunction(p);
    }
}
