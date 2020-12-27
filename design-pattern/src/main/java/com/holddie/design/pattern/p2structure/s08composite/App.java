package com.holddie.design.pattern.p2structure.s08composite;


import com.holddie.design.pattern.p2structure.s08composite.simple_module.implementor.Developer;
import com.holddie.design.pattern.p2structure.s08composite.simple_module.implementor.Manager;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Developer developer1 = new Developer("001", 011);
        Developer developer2 = new Developer("002", 012);
        Developer developer3 = new Developer("003", 013);

        Manager manager = new Manager("000", 1000);
        manager.add(developer1);
        manager.add(developer2);
        manager.add(developer3);

        manager.print();

    }
}
