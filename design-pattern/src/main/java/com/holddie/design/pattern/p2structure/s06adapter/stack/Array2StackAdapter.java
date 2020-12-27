package com.holddie.design.pattern.p2structure.s06adapter.stack;

/**
 * 数组数据结构适配栈数据结构
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 11:51
 */
public class Array2StackAdapter<T> implements IStack<T> {

    private static final int DEFAULT_CAPACITY = 15;

    private int top; // 指向栈顶元素

    private T[] array;


    public Array2StackAdapter(int initialCapacity) {
        if (initialCapacity <= 0) {
            array = (T[]) new Object[DEFAULT_CAPACITY];
        } else {
            array = (T[]) new Object[initialCapacity];
        }
        this.top = -1;
    }

    public Array2StackAdapter() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public T pop() throws StackException {
        T x = peek();
        array[top] = null;
        top--;
        return x;
    }

    @Override
    public T peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is Empty");
        }
        return array[top];
    }

    @Override
    public void push(T e) throws StackException {
        if (top == array.length) {
            throw new StackException("Stack has overFlowed");
        }
        top++;
        array[top] = e;
    }

    @Override
    public void clear() {
        for (T x :
                array) {
            x = null;
        }
        top = -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[ ]";
        }
        StringBuilder out = new StringBuilder("[");
        for (T x :
                array) {
            out.append(x).append(" ,");
        }
        out.substring(0, out.length() - 2);
        out.append("]");
        return out.toString();
    }
}
