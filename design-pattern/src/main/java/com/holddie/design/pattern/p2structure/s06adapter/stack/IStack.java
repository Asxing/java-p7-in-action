package com.holddie.design.pattern.p2structure.s06adapter.stack;

/**
 * 定义栈（一种数据结构）的标准方法
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 11:45
 */
public interface IStack<T> {

    public boolean isEmpty();

    public T pop() throws StackException;

    public T peek() throws StackException;

    public void push(T e) throws StackException;

    public void clear();

}
