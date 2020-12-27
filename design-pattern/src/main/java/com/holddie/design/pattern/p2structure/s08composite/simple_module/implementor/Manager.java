package com.holddie.design.pattern.p2structure.s08composite.simple_module.implementor;

import com.holddie.design.pattern.p2structure.s08composite.simple_module.abstraction.IEmployee;

import java.util.ArrayList;
import java.util.List;

/**
 * Boss
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 9:17
 */
public class Manager implements IEmployee {

    private String name;
    private double salary;
    private List<IEmployee> employees = new ArrayList<>();

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add(IEmployee employee) {
        employees.add(employee);
    }

    @Override
    public void reemove(IEmployee employee) {
        employees.remove(employee);
    }

    @Override
    public IEmployee getChild(int i) {
        return employees.get(i);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void print() {
        System.out.println("--------------------");
        System.out.println("name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("--------------------");
        for (IEmployee ep : employees) {
            ep.print();
        }
    }
}
