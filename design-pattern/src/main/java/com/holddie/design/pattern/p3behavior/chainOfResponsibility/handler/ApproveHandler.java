package com.holddie.design.pattern.p3behavior.chainOfResponsibility.handler;

import com.holddie.design.pattern.p3behavior.chainOfResponsibility.entity.Leave;

/**
 * 调用链抽象接口
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/3 16:58
 */
public interface ApproveHandler {

    public void setNextHandler(ApproveHandler nextHandler);

    public void approve(Leave leave);
}
