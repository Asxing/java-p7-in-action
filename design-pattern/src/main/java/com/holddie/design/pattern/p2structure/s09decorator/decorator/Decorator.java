package com.holddie.design.pattern.p2structure.s09decorator.decorator;


import com.holddie.design.pattern.p2structure.s09decorator.component.BakeryComponent;

/**
 * 抽象装饰器类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/30 9:49
 */
public abstract class Decorator implements BakeryComponent {

    private BakeryComponent bakeryComponent = null;

    protected String name = "Undefined Decorator";
    protected double price = 0.0;

    public Decorator(BakeryComponent bakeryComponent) {
        this.bakeryComponent = bakeryComponent;
    }

    @Override
    public String getName() {
        return this.bakeryComponent.getName() + ", " + this.name;
    }

    @Override
    public double getPrice() {
        return this.price + this.bakeryComponent.getPrice();
    }
}
