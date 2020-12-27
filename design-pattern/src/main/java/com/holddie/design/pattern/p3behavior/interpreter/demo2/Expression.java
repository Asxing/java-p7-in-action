package com.holddie.design.pattern.p3behavior.interpreter.demo2;

import java.util.Map;

public interface Expression {
    boolean interpret(Map<String, Long> stats);
}

// LessExpression/EqualExpression跟GreaterExpression代码类似，这里就省略了
