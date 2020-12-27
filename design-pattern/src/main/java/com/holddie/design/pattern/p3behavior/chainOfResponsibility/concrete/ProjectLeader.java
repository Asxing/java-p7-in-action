package com.holddie.design.pattern.p3behavior.chainOfResponsibility.concrete;


import com.holddie.design.pattern.p3behavior.chainOfResponsibility.entity.Leave;

/**
 * 项目经理
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/3 17:10
 */
public class ProjectLeader extends AbstractLeader {
    private static final int MAX_LEAVES_CAN_APPROVE = 20;

    @Override
    public void approve(Leave leave) {

        if (leave.getNumberOfDays() < MAX_LEAVES_CAN_APPROVE) {
            String output = String.format(
                    "LeaveId: %d, Days: %d, Approver: %s",
                    leave.getLeaveId(),
                    leave.getNumberOfDays(),
                    "ProjectLeader");
            System.out.println(output);
        } else {
            if (nextHandler != null) {
                nextHandler.approve(leave);
            }
        }
    }
}
