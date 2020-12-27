package com.holddie.design.pattern.p2structure.s08composite.simple_module.implementor;


import com.holddie.design.pattern.p2structure.s08composite.simple_module.abstraction.IEmployee;

/**
 * 开发
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 9:12
 */
public class Developer implements IEmployee {
    private String name;
    private double salary;

    public Developer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add(IEmployee employee) {
        String msg = "not supported by leaf node";
        throw new UnsupportedOperationException(msg);
    }

    @Override
    public void reemove(IEmployee employee) {
        String msg = "not supported by leaf node";
        throw new UnsupportedOperationException(msg);
    }

    @Override
    public IEmployee getChild(int i) {
        String msg = "not supported by leaf node";
        throw new UnsupportedOperationException(msg);
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
    }
}
