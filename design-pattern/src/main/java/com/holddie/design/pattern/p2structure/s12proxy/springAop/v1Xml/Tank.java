package com.holddie.design.pattern.p2structure.s12proxy.springAop.v1Xml;

import java.util.Random;

/**
 * @author HoldDie
 * @version 1.0
 * @date 2020/8/31 1:13 PM
 */
public class Tank {
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
