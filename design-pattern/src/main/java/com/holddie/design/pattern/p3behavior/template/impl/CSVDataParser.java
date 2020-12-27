package com.holddie.design.pattern.p3behavior.template.impl;


import com.holddie.design.pattern.p3behavior.template.abstracts.AbstractDataParser;

/**
 * CSV处理数据
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/9 16:05
 */
public class CSVDataParser extends AbstractDataParser {
    @Override
    protected void processData() {
        System.out.println("Looping through records in CSV");
    }

    @Override
    protected void readData() {
        System.out.println("Reading data from CSV");
    }
}
