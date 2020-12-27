package com.holddie.design.pattern.p2structure.s12proxy.staticProxy;

public class TankTimeProxy implements Movable {
    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    private final Movable movable;

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
