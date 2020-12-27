package com.holddie.design.pattern.p3behavior.template.impl;

import com.holddie.design.pattern.p3behavior.template.abstracts.AbstractDataParser;

/**
 * 数据库处理数据
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/9 16:06
 */
public class DatabaseDataParser extends AbstractDataParser {
    @Override
    protected void processData() {
        System.out.println("Looping though records in DB");
    }

    @Override
    protected void readData() {
        System.out.println("Reading data from database");
    }

    @Override
    protected void writeData() {
        System.out.println("Output generated,Writing to DB");
    }
}
