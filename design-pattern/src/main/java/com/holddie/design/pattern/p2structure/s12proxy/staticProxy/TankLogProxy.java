package com.holddie.design.pattern.p2structure.s12proxy.staticProxy;

public class TankLogProxy implements Movable {
    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    private final Movable movable;

    @Override
    public void move() {
        System.out.println("start moving.....");
        movable.move();
        System.out.println("end moving...");
    }
}
