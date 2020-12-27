package com.holddie.design.pattern.p1creation.c03abstractFactory;

/**
 * 中国工厂
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/23 9:25
 */
public class ChineseElectricalFactory implements IElectricalFactory {
    @Override
    public IFan createFan() {
        return new ChineseFan();
    }

    @Override
    public ITubeLight createTubeLight() {
        return new ChineseTubeLight();
    }
}
