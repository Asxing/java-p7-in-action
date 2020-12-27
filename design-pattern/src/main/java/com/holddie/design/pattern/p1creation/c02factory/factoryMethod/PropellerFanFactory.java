package com.holddie.design.pattern.p1creation.c02factory.factoryMethod;

/**
 * ProperFan工厂方法类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/23 9:00
 */
public class PropellerFanFactory implements IFanFactory {
    @Override
    public IFan createFan() {
        return new ProperFan();
    }

    private class ProperFan implements IFan {
        @Override
        public void switchOn() {

        }

        @Override
        public void switchOff() {

        }
    }
}
