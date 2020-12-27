package com.holddie.design.pattern.p2structure.s12proxy.staticProxy;

public class Main {
	public static void main(String[] args) {
		Tank tank = new Tank();
		TankTimeProxy tankTimeProxy = new TankTimeProxy(tank);
		TankLogProxy tankLogProxy = new TankLogProxy(tankTimeProxy);
		tankLogProxy.move();
	}
}
