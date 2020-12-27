package com.holddie.design.pattern.p2structure.s07bridge.implemention;

/**
 * 下载具体实现抽象
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/28 9:37
 */
public interface FileDownloadImplementor {

    public Object downloadFile(String path);

    public boolean storeFile(Object object);
}
