package com.holddie.design.pattern.p3behavior.strategy.manager;

import com.holddie.design.pattern.p3behavior.strategy.abstracts.AbstractSortStratrgy;
import lombok.Data;

import java.util.List;

/**
 * 业务调用逻辑
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/7 10:19
 */
@Data
public class SortingManager {

    AbstractSortStratrgy sortStratrgy;

    List<Integer> list;

    public SortingManager() {}

    public SortingManager(AbstractSortStratrgy sortStratrgy, List<Integer> list) {
        this.sortStratrgy = sortStratrgy;
        this.list = list;
    }

    public void sortList() {
        System.out.println("=========================");
        sortStratrgy.sort(list);
    }
}
