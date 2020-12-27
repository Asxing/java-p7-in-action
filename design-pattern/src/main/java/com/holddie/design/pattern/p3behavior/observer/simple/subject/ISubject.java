package com.holddie.design.pattern.p3behavior.observer.simple.subject;

import com.holddie.design.pattern.p3behavior.observer.simple.observer.IObserver;

/**
 * 抽象主题
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/8 9:44
 */
public interface ISubject {
    public void register(IObserver observer);

    public void unregister(IObserver observer);

    public void notifyAllObserver(String s);
}
