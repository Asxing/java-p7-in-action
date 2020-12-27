package com.holddie.design.pattern.p2structure.s12proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeProxy implements InvocationHandler {
	public TimeProxy(Movable movable) {
		this.movable = movable;
	}

	Movable movable;

	public void before() {
		System.out.println("Before");
	}

	public void after() {
		System.out.println("After");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		Object object = method.invoke(movable, args);
		after();
		return object;
	}
}
