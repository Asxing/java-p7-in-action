package com.holddie.design.pattern.p1creation.c02factory.nofactory;

/**
 * 无工厂类
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/22 10:01
 */
public class NoFactoryMain {

    public static void main(String[] args) {
        TableFan tableFan = new TableFan();
        tableFan.switchOn();
    }
}

class TableFan {
    public void switchOn() {
        System.out.println("the TableFan is switched on....");
    }
}
