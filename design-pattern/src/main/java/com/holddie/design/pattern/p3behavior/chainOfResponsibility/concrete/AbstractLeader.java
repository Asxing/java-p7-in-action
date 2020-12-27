package com.holddie.design.pattern.p3behavior.chainOfResponsibility.concrete;

import com.holddie.design.pattern.p3behavior.chainOfResponsibility.handler.ApproveHandler;

/**
 * 抽象Leader
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/3 17:03
 */
public abstract class AbstractLeader implements ApproveHandler {
    protected ApproveHandler nextHandler;

    @Override
    public void setNextHandler(ApproveHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
