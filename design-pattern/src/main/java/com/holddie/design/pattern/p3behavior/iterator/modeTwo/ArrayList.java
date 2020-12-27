package com.holddie.design.pattern.p3behavior.iterator.modeTwo;

import com.holddie.design.pattern.p3behavior.iterator.modeOne.Iterator;
import com.holddie.design.pattern.p3behavior.iterator.modeOne.List;

/**
 * 还有优化空间， 我们可以在 ArrayList 中存储两个数组。一个支持标记删除的，用来实现快照遍历功能； 一个不支持标记删除的（也就是将要删除的数据直接从数组中移除），用来支持随机访问。
 *
 * @param <E>
 */
public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int actualSize; // 不包含标记删除元素
    private int totalSize; // 包含标记删除元素

    private Object[] elements;
    private long[] addTimestamps;
    private long[] delTimestamps;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.addTimestamps = new long[DEFAULT_CAPACITY];
        this.delTimestamps = new long[DEFAULT_CAPACITY];
        this.totalSize = 0;
        this.actualSize = 0;
    }

    @Override
    public void add(E obj) {
        elements[totalSize] = obj;
        addTimestamps[totalSize] = System.currentTimeMillis();
        delTimestamps[totalSize] = Long.MAX_VALUE;
        totalSize++;
        actualSize++;
    }

    @Override
    public void remove(E obj) {
        for (int i = 0; i < totalSize; ++i) {
            if (elements[i].equals(obj)) {
                delTimestamps[i] = System.currentTimeMillis();
                actualSize--;
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new SnapshotArrayIterator<>(this);
    }

    public int actualSize() {
        return this.actualSize;
    }

    public int totalSize() {
        return this.totalSize;
    }

    public E get(int i) {
        if (i >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[i];
    }

    public long getAddTimestamp(int i) {
        if (i >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
        return addTimestamps[i];
    }

    public long getDelTimestamp(int i) {
        if (i >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
        return delTimestamps[i];
    }
}
