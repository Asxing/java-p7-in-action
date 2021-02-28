package com.holddie.jvm.classloader.v4;

import com.holddie.jvm.classloader.v4.cmd.ContineWorkCmd;
import com.holddie.jvm.classloader.v4.cmd.PrepareUpgradeCmd;
import com.holddie.jvm.classloader.v4.cmd.StartUpgradeCmd;

// 升级控制实体关键代码
public class UpgradeController extends ActiveObject {
    int nready = 0;
    int nfinished = 0;
    Worker[] workers;

    // 收到外部升级命令消息时，会触发该方法被调用
    public void askForUpgrade() {
        for (int i = 0; i < workers.length; i++)
            workers[i].getTaskQueue().enqueue(new PrepareUpgradeCmd(workers[i]));
    }

    // 收到工作实体回应的准备就绪命令消息时，会触发该方法被调用
    public void readyForUpgrade(String worker_name) {
        nready++;
        if (nready == workers.length) {
            for (int i = 0; i < workers.length; i++) {
                workers[i].getControlQueue().enqueue(new StartUpgradeCmd(workers[i]));
            }
        }
    }

    // 收到工作实体回应的升级完毕命令消息时，会触发该方法被调用
    public void finishUpgrade(String worker_name) {
        nfinished++;
        if (nfinished == workers.length) {
            for (int i = 0; i < workers.length; i++) {
                workers[i].getControlQueue().enqueue(new ContineWorkCmd(workers[i]));
            }
        }
    }

    public ActiveObject getMsgQueue() {
        return null;
    }
}
