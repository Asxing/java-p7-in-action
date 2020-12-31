package com.holddie.design.pattern.p2structure.s06adapter.machineadapter.queue;

/**
 * 队列基本方法
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 15:20
 */
public interface IQueue<T> {

    boolean add(T t);

    T poll();

    T peek();

    boolean isEmpty();
}
