package com.holddie.design.pattern.p3behavior.command.util;

import com.holddie.design.pattern.p3behavior.command.receiver.FileSystemReceiver;
import com.holddie.design.pattern.p3behavior.command.receiver.UnixFileSystemReveiver;
import com.holddie.design.pattern.p3behavior.command.receiver.WindowsFileSystemReceiver;

/**
 * 获取操作系统对应实现类
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/4 10:21
 */
public class FileSystemReceiverUtil {

    public static FileSystemReceiver getUnderlyingFileSystem() {
        String osName = System.getProperty("os.name");
        System.out.println("Underlying OS is : " + osName);
        if (osName.contains("Windows")) {
            return new WindowsFileSystemReceiver();
        } else {
            return new UnixFileSystemReveiver();
        }
    }
}
