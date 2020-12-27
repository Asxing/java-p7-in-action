package com.holddie.design.pattern.p2structure.s12proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimeMethodInterceptor implements MethodInterceptor {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println(o.getClass().getSuperclass().getName());
		System.out.println("Before");
		Object result = methodProxy.invokeSuper(o, objects);
		System.out.println("After");
		return result;
	}
}
