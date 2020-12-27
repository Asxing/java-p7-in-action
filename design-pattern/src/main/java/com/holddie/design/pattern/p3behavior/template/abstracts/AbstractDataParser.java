package com.holddie.design.pattern.p3behavior.template.abstracts;

/**
 * 抽象模板方法
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/9 16:00
 */
public abstract class AbstractDataParser {

    public final void process() {
        readData();
        processData();
        writeData();
    }

    protected void writeData() {
        System.out.println("Output generated,Writing to CSV");
    }

    protected abstract void processData();

    protected abstract void readData();

}
