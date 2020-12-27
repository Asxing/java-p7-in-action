package com.holddie.design.pattern.p3behavior.interpreter.demo1.implement;

import com.holddie.design.pattern.p3behavior.interpreter.demo1.abs.AbstractExpression;

/**
 * 减运算
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/5 9:26
 */
public class MinusExpression extends AbstractExpression {

    private AbstractExpression leftExpression;
    private AbstractExpression rightExpression;

    public MinusExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }

    @Override
    public String toString() {
        return "-";
    }
}
