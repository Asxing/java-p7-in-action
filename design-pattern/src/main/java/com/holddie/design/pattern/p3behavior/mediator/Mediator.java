package com.holddie.design.pattern.p3behavior.mediator;

public abstract class Mediator {
	
	//抽象的发送消息方法
	public abstract void send(String message, Colleague colleague);
	
}
