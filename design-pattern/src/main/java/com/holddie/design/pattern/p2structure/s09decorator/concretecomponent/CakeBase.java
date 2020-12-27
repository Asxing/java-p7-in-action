package com.holddie.design.pattern.p2structure.s09decorator.concretecomponent;

import com.holddie.design.pattern.p2structure.s09decorator.component.BakeryComponent;
import lombok.Data;

/**
 * 蛋糕底盘
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/30 9:45
 */
@Data
public class CakeBase implements BakeryComponent {

    private String name = "Cake Base";

    private double price = 200.0;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
