package com.holddie.design.pattern.p1creation.c01singlton;

/**
 * 饿汉模式（静态代码块）
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/24 10:03
 */
public class Singleton02 {
    private static final Singleton02 INSTANCE;

    private Singleton02() {
    }

    static {
        try {
            INSTANCE = new Singleton02();
        } catch (Exception e) {
            throw new RuntimeException(" error! ");
        }
    }

    public static Singleton02 getInstance() {
        return INSTANCE;
    }

}
