package com.holddie.design.pattern.p2structure.s07bridge.implemention_change;

/**
 * Windows 下载具体实现
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/28 9:41
 */
public class WindowsFileDownloadImplementor implements FileDownloadImplementor {
    @Override
    public Object downloadFile(String path) {
        return new Object();
    }

    @Override
    public boolean storeFile(Object object) {
        System.out.println("File down successfully in Windows");
        return true;
    }

    @Override
    public boolean delete(String path) {
        return false;
    }
}
