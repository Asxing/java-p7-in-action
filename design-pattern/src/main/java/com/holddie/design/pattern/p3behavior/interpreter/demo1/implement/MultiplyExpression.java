package com.holddie.design.pattern.p3behavior.interpreter.demo1.implement;


import com.holddie.design.pattern.p3behavior.interpreter.demo1.abs.AbstractExpression;

/**
 * 乘运算符
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/5 9:28
 */
public class MultiplyExpression extends AbstractExpression {
    private AbstractExpression leftExpression;
    private AbstractExpression rightExpression;

    public MultiplyExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() * rightExpression.interpret();
    }

    @Override
    public String toString() {
        return "*";
    }
}
