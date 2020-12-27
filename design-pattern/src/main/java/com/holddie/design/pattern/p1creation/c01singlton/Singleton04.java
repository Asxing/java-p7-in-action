package com.holddie.design.pattern.p1creation.c01singlton;

/**
 * 懒汉模式（同步）
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/24 10:09
 */
public class Singleton04 {
    private static Singleton04 INSTANCE;

    private Singleton04() {}

    private static synchronized Singleton04 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton04();
        }
        return INSTANCE;
    }
}
