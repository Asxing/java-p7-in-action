package com.holddie.design.pattern.p2structure.s06adapter.machineadapter.impl;

import com.holddie.design.pattern.p2structure.s06adapter.machineadapter.interfac.IHdmi;
import com.holddie.design.pattern.p2structure.s06adapter.machineadapter.interfac.IVga;

/**
 * VGA 接口适配 HDMI 接口
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 11:37
 */
public class Vga2HdmiAdapter implements IHdmi {

    private IVga vga;

    public Vga2HdmiAdapter(IVga vga) {
        this.vga = vga;
    }

    @Override
    public void openHdmi() {
        vga.openVga();
        System.out.println("Openning HDMI device.....");
        System.out.println("适配完成");
    }
}
