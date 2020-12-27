package com.holddie.design.pattern.p3behavior.chainOfResponsibility.concrete;


import com.holddie.design.pattern.p3behavior.chainOfResponsibility.entity.Leave;

/**
 * 人力主管
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/3 17:11
 */
public class HRLeader extends AbstractLeader {
    private static final int MAX_LEAVES_CAN_APPROVE = 30;

    @Override
    public void approve(Leave leave) {

        if (leave.getNumberOfDays() < MAX_LEAVES_CAN_APPROVE) {
            String output = String.format(
                    "LeaveId: %d, Days: %d, Approver: %s",
                    leave.getLeaveId(),
                    leave.getNumberOfDays(),
                    "HRLeader");
            System.out.println(output);
        } else {
            if (nextHandler != null) {
                nextHandler.approve(leave);
            } else {
                System.out.println("Leave application suspended, Please contact HR!");
            }
        }
    }
}
