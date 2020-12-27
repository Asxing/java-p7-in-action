package com.holddie.design.pattern.p3behavior.strategy.implement;

import com.holddie.design.pattern.p3behavior.strategy.abstracts.AbstractSortStratrgy;

import java.util.List;

/**
 * 堆排序
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/7 10:15
 */
public class HeapSortStrategy implements AbstractSortStratrgy {
    @Override
    public void sort(List<Integer> list) {
        System.out.println("Heap Sorting ..");
    }
}
