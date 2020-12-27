package com.holddie.design.pattern.p2structure.s12proxy.springAop.v1Xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Tank tank = (Tank) context.getBean("tank");
        tank.move();
    }
}
