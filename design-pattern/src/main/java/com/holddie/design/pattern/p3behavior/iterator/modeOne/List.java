package com.holddie.design.pattern.p3behavior.iterator.modeOne;

public interface List<E> {
    void add(E obj);

    void remove(E obj);

    Iterator iterator();
}
