package com.holddie.design.pattern.p2structure.s06adapter.stack;

/**
 * Stack测试类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/27 12:08
 */
public class ArrayStatckMain {

    public static void main(String[] args) {
        IStack<Integer> stack = new Array2StackAdapter<>(15);


        for (int i = 0; i < 13; i++) {
            stack.push(i);
        }

        System.out.println(stack);

        try {
            for (int i = 0; i < 14; i++) {
                System.out.println(stack.pop());
            }
        } catch (StackException e) {
            System.out.println("异常喽！");
            e.printStackTrace();
        }

    }

}
