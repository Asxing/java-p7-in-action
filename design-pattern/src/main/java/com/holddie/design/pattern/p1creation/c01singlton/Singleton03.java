package com.holddie.design.pattern.p1creation.c01singlton;

/**
 * 懒汉模式
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/24 10:08
 */
public class Singleton03 {
    private static Singleton03 INSTANCE;

    private Singleton03() {}

    public static Singleton03 getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }
}
