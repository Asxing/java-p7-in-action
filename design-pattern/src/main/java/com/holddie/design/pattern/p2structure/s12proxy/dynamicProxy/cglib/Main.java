package com.holddie.design.pattern.p2structure.s12proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author HoldDie
 * @version 1.0
 * @date 2020/8/31 1:28 PM
 */
public class Main {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Tank.class);
		enhancer.setCallback(new TimeMethodInterceptor());
		Tank tank = (Tank) enhancer.create();
		tank.move();
	}
}
