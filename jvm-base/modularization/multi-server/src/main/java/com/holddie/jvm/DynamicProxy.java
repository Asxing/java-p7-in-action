package com.holddie.jvm;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        Long end = System.currentTimeMillis();
        String format = String.format("执行: class => %s, 方法=> %s, 参数 => %s, 耗时 => %sms, 执行结果 => %s, 当前路径 => %s",
                target.getClass().getName(),
                method.getName(),
                JSON.toJSON(args),
                end - start,
                JSON.toJSON(result),
                target.getClass().getResource("").getPath());
        System.out.println(format);
        return result;
    }
}
