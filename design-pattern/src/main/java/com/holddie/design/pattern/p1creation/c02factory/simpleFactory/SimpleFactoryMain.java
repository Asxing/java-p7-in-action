package com.holddie.design.pattern.p1creation.c02factory.simpleFactory;

/**
 * 客户端代码
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/22 10:11
 */
public class SimpleFactoryMain {
    public static void main(String[] args) {
        IFactory factory = new FanFactory();
        IFan fan = factory.createFan(FanType.TableFan);
        fan.switchOn();
        fan.swtichOff();
    }
}
