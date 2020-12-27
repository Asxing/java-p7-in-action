package com.holddie.design.pattern.p1creation.c05builder.classicBuilder.builder;

import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.MobilePhone;

/**
 * 抽象接口（演员的基本素养）
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/25 10:34
 */
public interface IMobilePhoneBuilder {
    /**
     * 组装电池
     *
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:35
     */
    void buildBattery();

    /**
     * 组装操作系统
     *
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:35
     */
    void buildOS();

    /**
     * 组装屏幕
     *
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:35
     */
    void buildScreen();

    /**
     * 是否触屏
     *
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:36
     */
    void buildStylus();

    /**
     * 获取实体
     *
     * @return MobilePhone
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:50
     */
    MobilePhone builder();
}
