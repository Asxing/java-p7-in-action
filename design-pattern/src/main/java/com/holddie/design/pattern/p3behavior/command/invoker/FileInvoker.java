package com.holddie.design.pattern.p3behavior.command.invoker;

import com.holddie.design.pattern.p3behavior.command.command.Command;

/**
 * 文件调用者
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/4 10:08
 */
public class FileInvoker {
    private Command command;

    public FileInvoker(Command command) {
        this.command = command;
    }

    public void execute() {
        this.command.execute();
    }
}
