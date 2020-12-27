package com.holddie.design.pattern.p1creation.c03abstractFactory;

/**
 * 美国工厂方法
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/23 9:27
 */
public class UsElectricalFactory implements IElectricalFactory {
    @Override
    public IFan createFan() {
        return new UsFan();
    }

    @Override
    public ITubeLight createTubeLight() {
        return new UsTubeLight();
    }
}
