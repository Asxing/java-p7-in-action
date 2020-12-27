package com.holddie.design.pattern.p2structure.s09decorator.concretedecorator;


import com.holddie.design.pattern.p2structure.s09decorator.component.BakeryComponent;
import com.holddie.design.pattern.p2structure.s09decorator.decorator.Decorator;

/**
 * 名片功能费用
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/30 9:56
 */
public class NameCardDecorator extends Decorator {
    public NameCardDecorator(BakeryComponent bakeryComponent) {
        super(bakeryComponent);
        this.name = "NameCard";
        this.price = 4.0;
    }
}
