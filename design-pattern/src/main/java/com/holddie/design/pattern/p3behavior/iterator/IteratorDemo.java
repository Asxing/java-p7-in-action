package com.holddie.design.pattern.p3behavior.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(8);
        list.add(5);

        Iterator<Integer> iterator = list.iterator();
        list.remove(Integer.valueOf(2));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--second print--");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("什么有没有输出");

        // 第二次输出
    }
}
