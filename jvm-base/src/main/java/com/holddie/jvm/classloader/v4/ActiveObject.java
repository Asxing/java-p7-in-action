package com.holddie.jvm.classloader.v4;

//ActiveObject的定义
public class ActiveObject extends Thread {
    private ActiveQueue _queue;

    public ActiveObject() {
        _queue = new ActiveQueue();
        start();
    }

    public void enqueue(MethodRequest mr) {
        _queue.enqueue(mr);
    }

    public void run() {
        while (true) {
            MethodRequest mr = _queue.dequeue();
            mr.call();
        }
    }
}