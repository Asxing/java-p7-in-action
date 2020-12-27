package com.holddie.design.pattern.p3behavior.mediator;

/**
 * @author zeyangg
 */
public class Client {
	
	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		
		ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
		ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);
		
		mediator.setColleague1(colleague1);
		mediator.setColleague2(colleague2);
		
		colleague1.send("Nice to meet u.");
		colleague2.send("Nice to meet u too.");
	}

}
