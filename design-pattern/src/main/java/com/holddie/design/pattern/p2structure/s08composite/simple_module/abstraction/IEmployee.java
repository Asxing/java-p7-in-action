package com.holddie.design.pattern.p2structure.s08composite.simple_module.abstraction;

/**
 * 员工抽象
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/29 9:09
 */
public interface IEmployee {

    public void add(IEmployee employee);

    public void reemove(IEmployee employee);

    public IEmployee getChild(int i);

    public String getName();

    public double getSalary();

    public void print();
}
