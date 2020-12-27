package com.holddie.design.pattern.p1creation.c02factory.simpleFactory;

/**
 * 工厂类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/22 10:07
 */
public class FanFactory implements IFactory {
    @Override
    public IFan createFan(FanType type) {
        switch (type) {
            case TableFan:
                return new TableFan();
            case CeilingFan:
                return new CeilingFan();
            case ExhaustFan:
                return new ExhaustFan();
            default:
                return new TableFan();
        }
    }
}
