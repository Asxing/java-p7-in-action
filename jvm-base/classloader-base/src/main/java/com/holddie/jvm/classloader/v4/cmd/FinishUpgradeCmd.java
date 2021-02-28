package com.holddie.jvm.classloader.v4.cmd;

import com.holddie.jvm.classloader.v4.MethodRequest;
import com.holddie.jvm.classloader.v4.UpgradeController;
import com.holddie.jvm.classloader.v4.Worker;

public class FinishUpgradeCmd implements MethodRequest {
    public FinishUpgradeCmd(UpgradeController ugc, Worker worker) {}

    @Override
    public void call() {}
}
