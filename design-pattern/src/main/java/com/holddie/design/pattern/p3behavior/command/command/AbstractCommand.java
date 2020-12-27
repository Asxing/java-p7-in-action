package com.holddie.design.pattern.p3behavior.command.command;


import com.holddie.design.pattern.p3behavior.command.receiver.FileSystemReceiver;

/**
 * 抽象命令实现类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/4 10:34
 */
public class AbstractCommand {

    protected FileSystemReceiver fileSystemReceiver;

    public AbstractCommand(FileSystemReceiver fileSystemReceiver) {
        this.fileSystemReceiver = fileSystemReceiver;
    }

}
