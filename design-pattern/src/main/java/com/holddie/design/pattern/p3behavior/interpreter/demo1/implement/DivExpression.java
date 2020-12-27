package com.holddie.design.pattern.p3behavior.interpreter.demo1.implement;


import com.holddie.design.pattern.p3behavior.interpreter.demo1.abs.AbstractExpression;

/**
 * 除运算符
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/5 9:29
 */
public class DivExpression extends AbstractExpression {
    private AbstractExpression leftExpression;
    private AbstractExpression rightExpression;

    public DivExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        if (rightExpression.interpret() == 0) {
            try {
                throw new Exception("除数不可以为0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.rightExpression = rightExpression;
        }
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() / rightExpression.interpret();
    }

    @Override
    public String toString() {
        return "/";
    }
}
