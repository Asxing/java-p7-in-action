package com.holddie.jvm.classloader.v4;

import com.holddie.jvm.classloader.v3.AXClassLoader;
import com.holddie.jvm.classloader.v4.cmd.FinishUpgradeCmd;
import com.holddie.jvm.classloader.v4.cmd.ReadyForUpdateCmd;
import lombok.SneakyThrows;

// 工作实体关键代码
public class Worker extends ActiveObject {
    private static final String packagePath = "com.holddie.jvm.classloader.v3";
    UpgradeController ugc;
    AXClassLoader hscl;
    IFoo foo;
    String state = "hello world!";

    // 收到升级控制实体的准备升级命令消息时，会触发该方法被调用
    public void prepareUpgrade() {
        switchToControlQueue();
        ugc.getMsgQueue().enqueue(new ReadyForUpdateCmd(ugc, this));
    }

    private void switchToControlQueue() {

    }

    // 收到升级控制实体的开始升级命令消息时，会触发该方法被调用
    public void startUpgrade(String worker_name) {
        doUpgrade();
        ugc.getMsgQueue().enqueue(new FinishUpgradeCmd(ugc, this));
    }

    // 收到升级控制实体的继续工作命令消息时，会触发该方法被调用
    public void continueWork(String worker_name) {
        switchToTaskQueue();
    }

    private void switchToTaskQueue() {

    }

    // 收到定时命令消息时，会触发该方法被调用
    public void doWork() {
        foo.sayHello();
    }

    // 实际升级动作
    @SneakyThrows
    private void doUpgrade() {
        AXClassLoader cl = new AXClassLoader(ClassLoader.getSystemResource("").getPath() + "v3/", new String[]{"Foo"}, packagePath);
        Class cls = cl.loadClass(packagePath + ".Foo");
        foo = (IFoo) cls.newInstance();
        foo.SetState(state);
    }

    public ActiveObject getTaskQueue() {
        return null;
    }

    public ActiveObject getControlQueue() {
        return null;
    }
}