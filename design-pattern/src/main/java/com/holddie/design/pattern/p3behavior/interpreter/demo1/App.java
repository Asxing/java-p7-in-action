package com.holddie.design.pattern.p3behavior.interpreter.demo1;


import com.holddie.design.pattern.p3behavior.interpreter.demo1.abs.AbstractExpression;
import com.holddie.design.pattern.p3behavior.interpreter.demo1.implement.DivExpression;
import com.holddie.design.pattern.p3behavior.interpreter.demo1.implement.MinusExpression;
import com.holddie.design.pattern.p3behavior.interpreter.demo1.implement.MultiplyExpression;
import com.holddie.design.pattern.p3behavior.interpreter.demo1.implement.NumberExpression;
import com.holddie.design.pattern.p3behavior.interpreter.demo1.implement.PlusExpression;

import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String tokenString = "40 4 3 2 - 1 + * /";
        Stack<AbstractExpression> stack = new Stack<>();

        String[] tokenList = tokenString.split(" ");
        for (String s :
                tokenList) {
            if (isOperator(s)) {
                AbstractExpression rightExpression = stack.pop();
                AbstractExpression leftExpression = stack.pop();

                AbstractExpression operator = getOperatorInstance(s, leftExpression, rightExpression);
                int result = operator.interpret();
                NumberExpression numberExpression = new NumberExpression(result);
                stack.push(numberExpression);
            } else {
                NumberExpression numberExpression = new NumberExpression(s);
                stack.push(numberExpression);
            }
        }

        System.out.println("result: " + stack.pop().interpret());

    }

    private static AbstractExpression getOperatorInstance(String s, AbstractExpression leftExpression, AbstractExpression rightExpression) {
        switch (s) {
            case "+":
                return new PlusExpression(leftExpression, rightExpression);
            case "-":
                return new MinusExpression(leftExpression, rightExpression);
            case "*":
                return new MultiplyExpression(leftExpression, rightExpression);
            case "/":
                return new DivExpression(leftExpression, rightExpression);
            default:
                return new PlusExpression(leftExpression, rightExpression);
        }
    }

    private static boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }
}
