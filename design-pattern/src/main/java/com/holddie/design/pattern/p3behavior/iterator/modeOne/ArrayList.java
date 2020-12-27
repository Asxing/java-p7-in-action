package com.holddie.design.pattern.p3behavior.iterator.modeOne;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int actualSize;
    // 不包含标记删除元素
    private int totalSize;
    // 包含标记删除元素
    private Object[] elements;

    @Override
    public void add(E obj) {}

    @Override
    public void remove(E obj) {}

    @Override
    public Iterator<E> iterator() {
        return new SnapshotArrayIterator(this);
    }

    public int size() {
        return actualSize;
    }

    public <E> E get(int cursor) {
        return (E) elements[cursor];
    }

    public void addAll(ArrayList arrayList) {
        // arrayList.elements
    }
}
