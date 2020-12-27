package com.holddie.design.pattern.p1creation.c01singlton;

/**
 * 懒汉模式双重检查机制
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/24 10:11
 */
public class Singleton05 {
    private static volatile Singleton05 INSTANCE;

    private Singleton05() {
    }

    public static Singleton05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton05.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton05();
                }
            }
        }
        return INSTANCE;
    }
}
