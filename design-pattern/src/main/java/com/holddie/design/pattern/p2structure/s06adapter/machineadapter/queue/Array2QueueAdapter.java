package com.holddie.design.pattern.p2structure.s06adapter.machineadapter.queue;

/**
 * 数组实现队列的功能
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 15:25
 */
public class Array2QueueAdapter<T> implements IQueue<T> {

    private static int CAPACITY = 40;
    private int capacity = 0;
    private T[] S;
    private int front = 0;
    private int rear = 0;

    Array2QueueAdapter(int capacity) {
        this.capacity = capacity;
        S = (T[]) new Object[capacity];
    }

    Array2QueueAdapter() {
        this(CAPACITY);
    }

    @Override
    public boolean add(T o) {
        if (getSize() == capacity - 1) {
            throw new QueueException("队列满，不能入队");
        } else {
            S[rear] = o;
            rear = (rear + 1) % capacity;
            return true;
        }
    }

    public int getSize() {
        return (CAPACITY + rear - front) % capacity;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            throw new QueueException("队列为空，不能出队");
        } else {
            T t = S[front];
            S[front] = null;
            front = (front + 1) % capacity;
            return t;
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new QueueException("队列为空，不能出队");
        } else {
            return S[front];
        }
    }

    @Override
    public boolean isEmpty() {
        if (front == rear) {
            return true;
        } else {
            return false;
        }
    }
}
