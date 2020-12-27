package com.holddie.design.pattern.p1creation.c05builder.classicBuilder.concreatebuilder;

import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.builder.IMobilePhoneBuilder;
import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.MobilePhone;
import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.enumEntity.BatteryType;
import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.enumEntity.OperationSystemType;
import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.enumEntity.ScreenType;
import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.product.enumEntity.StylusType;

/**
 * 安卓手机
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/25 10:36
 */
public class AndroidPhoneBuilder implements IMobilePhoneBuilder {

    // 手机实体
    private MobilePhone mobilePhone;

    public AndroidPhoneBuilder() {
        this.mobilePhone = new MobilePhone("Android Phone!");
    }

    /**
     * 组装电池
     *
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:35
     */
    @Override
    public void buildBattery() {
        mobilePhone.setPhoneBattery(BatteryType.MAH_1500);
    }

    /**
     * 组装操作系统
     *
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:35
     */
    @Override
    public void buildOS() {
        mobilePhone.setOperationSystemType(OperationSystemType.ANDROID);
    }

    /**
     * 组装屏幕
     *
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:35
     */
    @Override
    public void buildScreen() {
        mobilePhone.setPhoneScreenType(ScreenType.SCREEN_TYPE_TOUCH_RESISTIVE);
    }

    /**
     * 是否触屏
     *
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:36
     */
    @Override
    public void buildStylus() {
        mobilePhone.setStylusType(StylusType.YES);
    }

    /**
     * 获取实体
     *
     * @return MobilePhone
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/25 10:50
     */
    @Override
    public MobilePhone builder() {
        return this.mobilePhone;
    }
}
