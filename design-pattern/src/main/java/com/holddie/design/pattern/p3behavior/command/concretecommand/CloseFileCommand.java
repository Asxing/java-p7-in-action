package com.holddie.design.pattern.p3behavior.command.concretecommand;

import com.holddie.design.pattern.p3behavior.command.command.AbstractCommand;
import com.holddie.design.pattern.p3behavior.command.command.Command;
import com.holddie.design.pattern.p3behavior.command.receiver.FileSystemReceiver;

/**
 * 关闭文件
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/4 10:18
 */
public class CloseFileCommand extends AbstractCommand implements Command {

    public CloseFileCommand(FileSystemReceiver fileSystemReceiver) {
        super(fileSystemReceiver);
    }

    @Override
    public void execute() {
        this.fileSystemReceiver.closeFile();
    }
}
