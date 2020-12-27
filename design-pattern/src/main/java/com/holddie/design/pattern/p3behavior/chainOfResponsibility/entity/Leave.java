package com.holddie.design.pattern.p3behavior.chainOfResponsibility.entity;

import lombok.Data;

/**
 * 调用链处理对象
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/3 17:00
 */
@Data
public class Leave {

    private int leaveId;

    private int numberOfDays;

    public Leave(int leaveId, int numberOfDays) {
        this.leaveId = leaveId;
        this.numberOfDays = numberOfDays;
    }
}
