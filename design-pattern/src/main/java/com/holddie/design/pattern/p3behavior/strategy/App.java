package com.holddie.design.pattern.p3behavior.strategy;

import com.holddie.design.pattern.p3behavior.strategy.implement.HeapSortStrategy;
import com.holddie.design.pattern.p3behavior.strategy.implement.MergeSortStrategy;
import com.holddie.design.pattern.p3behavior.strategy.implement.QuickSortStrategy;
import com.holddie.design.pattern.p3behavior.strategy.manager.SortingManager;

import java.util.Arrays;
import java.util.List;

/** Hello world! */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Integer> list = Arrays.asList(23, 12, 45, 25, 67);

        MergeSortStrategy mergeSortStrategy = new MergeSortStrategy();
        SortingManager sortingManager = new SortingManager(mergeSortStrategy, list);
        sortingManager.sortList();

        QuickSortStrategy quickSortStrategy = new QuickSortStrategy();
        sortingManager.setSortStratrgy(quickSortStrategy);
        sortingManager.sortList();

        HeapSortStrategy heapSortStrategy = new HeapSortStrategy();
        sortingManager.setSortStratrgy(heapSortStrategy);
        sortingManager.sortList();
    }
}
