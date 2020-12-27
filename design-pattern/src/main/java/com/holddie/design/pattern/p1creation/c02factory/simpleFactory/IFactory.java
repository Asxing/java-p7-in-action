package com.holddie.design.pattern.p1creation.c02factory.simpleFactory;

/**
 * 抽象工厂接口
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/22 10:04
 */
public interface IFactory {

    IFan createFan(FanType type);
}
