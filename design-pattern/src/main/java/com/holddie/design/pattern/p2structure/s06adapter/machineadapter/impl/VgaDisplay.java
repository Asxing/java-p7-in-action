package com.holddie.design.pattern.p2structure.s06adapter.machineadapter.impl;

import com.holddie.design.pattern.p2structure.s06adapter.machineadapter.interfac.IVga;

/**
 * VGA 原先具体的操作
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 11:38
 */
public class VgaDisplay implements IVga {
    @Override
    public void openVga() {
        System.out.println("Openning ... VGA ... monitor");
    }
}
