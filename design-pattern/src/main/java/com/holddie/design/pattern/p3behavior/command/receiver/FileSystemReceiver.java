package com.holddie.design.pattern.p3behavior.command.receiver;

/**
 * 关闭文件实现类
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/4 10:19
 */
public interface FileSystemReceiver {

    void closeFile();

    void writeFile();

    void openFile();
}
