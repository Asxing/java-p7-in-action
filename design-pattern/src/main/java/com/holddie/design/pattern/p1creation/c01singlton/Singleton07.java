package com.holddie.design.pattern.p1creation.c01singlton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 枚举单例
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/24 10:16
 */
public enum Singleton07 {
    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}


class TestEnumSingleton{
    public static void main(String[] args) {
        System.out.println(Singleton07.INSTANCE.getId());
        System.out.println(Singleton07.INSTANCE.getId());
        System.out.println(Singleton07.INSTANCE.getId());
        System.out.println(Singleton07.INSTANCE.getId());
    }
}
