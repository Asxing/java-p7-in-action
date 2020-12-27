package com.holddie.design.pattern.p2structure.s12proxy.springAop.v2Annotaion;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TankTimeProxy {

    @Before("execution(void com.holddie.design.proxy.springAop.v2Annotaion.Tank.move())")
    public void before() {
        System.out.println("before");
    }

    @After("execution(void com.holddie.design.proxy.springAop.v2Annotaion.Tank.move())")
    public void after() {
        System.out.println("after");
    }
}
