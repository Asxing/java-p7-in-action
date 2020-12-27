package com.holddie.design.pattern.p2structure.s06adapter;


import com.holddie.design.pattern.p2structure.s06adapter.impl.Vga2HdmiAdapter;
import com.holddie.design.pattern.p2structure.s06adapter.impl.VgaDisplay;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        VgaDisplay vgaDisplay = new VgaDisplay();

        Vga2HdmiAdapter vga2HdmiAdapter = new Vga2HdmiAdapter(vgaDisplay);

        operateHdmiLaptop(vga2HdmiAdapter);

    }

    private static void operateHdmiLaptop(Vga2HdmiAdapter vga2HdmiAdapter) {
        vga2HdmiAdapter.openHdmi();
        System.out.println("HDMI 显示器调用成功了");
    }
}
