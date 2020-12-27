package com.holddie.design.pattern.p3behavior.mediator;


public abstract class Colleague {
	
	protected Mediator mediator;
	
	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}

}
