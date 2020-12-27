package com.holddie.design.pattern.p2structure.s12proxy.dynamicProxy.jdk;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();
        System.getProperties().setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        Movable movable =
                (Movable)
                        Proxy.newProxyInstance(
                                Tank.class.getClassLoader(),
                                new Class[] {Movable.class},
                                new TimeProxy(tank));
        movable.move();
    }
}
