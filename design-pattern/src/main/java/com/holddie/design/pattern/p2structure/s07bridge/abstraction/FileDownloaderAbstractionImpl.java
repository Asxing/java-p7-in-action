package com.holddie.design.pattern.p2structure.s07bridge.abstraction;


import com.holddie.design.pattern.p2structure.s07bridge.implemention.FileDownloadImplementor;

/**
 * 下载功能具体实现
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/28 9:43
 */
public class FileDownloaderAbstractionImpl implements FileDownloaderAbstraction {

    private FileDownloadImplementor provider = null;

    public FileDownloaderAbstractionImpl(FileDownloadImplementor fileDownloadImplementor) {
        super();
        this.provider = fileDownloadImplementor;
    }

    @Override
    public Object download(String path) {
        return provider.downloadFile(path);
    }

    @Override
    public boolean store(Object object) {
        return provider.storeFile(object);
    }
}
