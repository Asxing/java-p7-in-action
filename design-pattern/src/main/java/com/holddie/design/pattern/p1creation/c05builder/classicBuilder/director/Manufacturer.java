package com.holddie.design.pattern.p1creation.c05builder.classicBuilder.director;


import com.holddie.design.pattern.p1creation.c05builder.classicBuilder.builder.IMobilePhoneBuilder;

/**
 * 导演类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/25 10:20
 */
public class Manufacturer {

    public void construct(IMobilePhoneBuilder phoneBuilder){
        phoneBuilder.buildBattery();
        phoneBuilder.buildOS();
        phoneBuilder.buildScreen();
        phoneBuilder.buildStylus();
    }
}
