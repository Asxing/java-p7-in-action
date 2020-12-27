package com.holddie.design.pattern.p1creation.c02factory.factoryMethod;

/**
 * CeilingFanFactory工厂方法类
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/23 8:58
 */
public class CeilingFanFactory implements IFanFactory {
    @Override
    public IFan createFan() {
        return new CeilingFan();
    }

    private class CeilingFan implements IFan {
        @Override
        public void switchOn() {}

        @Override
        public void switchOff() {}
    }
}
