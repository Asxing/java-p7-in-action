package com.holddie.design.pattern.p3behavior.command.receiver;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/4 10:25
 */
public class UnixFileSystemReveiver implements FileSystemReceiver {
    @Override
    public void closeFile() {
        System.out.println("Closing file in unix OS");
    }

    @Override
    public void writeFile() {
        System.out.println("writing file in unix OS");
    }

    @Override
    public void openFile() {
        System.out.println("Opening file in unix OS");
    }
}
