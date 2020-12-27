package com.holddie.design.pattern.p2structure.s07bridge.abstraction_change;

/**
 * 升级版本功能抽象
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/28 9:50
 */
public interface FileDownloaderAbstraction {
    public Object download(String path);

    public boolean store(Object object);

    public boolean delete(String path);
}
