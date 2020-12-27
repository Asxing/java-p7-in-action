package com.holddie.design.pattern.p3behavior.strategy.implement;

import com.holddie.design.pattern.p3behavior.strategy.abstracts.AbstractSortStratrgy;

import java.util.List;

/**
 * 合并排序
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/7 10:14
 */
public class MergeSortStrategy implements AbstractSortStratrgy {
    @Override
    public void sort(List<Integer> list) {
        System.out.println("Merge Sorting ....");
    }
}
