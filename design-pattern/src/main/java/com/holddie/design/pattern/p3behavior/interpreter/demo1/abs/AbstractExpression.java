package com.holddie.design.pattern.p3behavior.interpreter.demo1.abs;

/**
 * 解释器抽象类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/5 9:19
 */
public abstract class AbstractExpression {

    public abstract int interpret();

    @Override
    public abstract String toString();
}
