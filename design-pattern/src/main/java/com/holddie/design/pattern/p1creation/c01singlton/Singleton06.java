package com.holddie.design.pattern.p1creation.c01singlton;

import java.io.Serializable;

/**
 * 比尔。普夫单例
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/24 10:14
 */
public class Singleton06 implements Serializable {
    private Singleton06() {}

    private static class LazyHolder {
        private static final Singleton06 INSTANCE = new Singleton06();
    }

    public static Singleton06 getInstance() {
        return LazyHolder.INSTANCE;
    }

    // 确保反序列化单例
    protected Object readResolve() {
        return getInstance();
    }
}
