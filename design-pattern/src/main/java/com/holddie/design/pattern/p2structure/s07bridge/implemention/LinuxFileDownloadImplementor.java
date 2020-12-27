package com.holddie.design.pattern.p2structure.s07bridge.implemention;

/**
 * Linux下载实现
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/28 9:39
 */
public class LinuxFileDownloadImplementor implements FileDownloadImplementor {
    @Override
    public Object downloadFile(String path) {
        return new Object();
    }

    @Override
    public boolean storeFile(Object object) {
        System.out.println("File download successFully in LINUX");
        return true;
    }
}
