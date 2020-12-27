package com.holddie.design.pattern.p2structure.s09decorator.concretedecorator;


import com.holddie.design.pattern.p2structure.s09decorator.component.BakeryComponent;
import com.holddie.design.pattern.p2structure.s09decorator.decorator.Decorator;

/**
 * 樱桃装饰功能
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/30 9:52
 */
public class CherryDecorator extends Decorator {

    public CherryDecorator(BakeryComponent bakeryComponent) {
        super(bakeryComponent);
        this.name = "Cherry";
        this.price = 2.0;
    }

}
