package com.holddie.design.pattern.p1creation.c01singlton.destorysingleton;


import com.holddie.design.pattern.p1creation.c01singlton.Singleton03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射破坏单例模式
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/24 10:19
 */
public class ReflectionSingleton {

    public static void main(String[] args) {

        Singleton03 singleton01 = Singleton03.getINSTANCE();

        Singleton03 singleton02 = null;

        Constructor constructor;

        try {
            constructor = Singleton03.class.getDeclaredConstructor();

            constructor.setAccessible(true);

            singleton02 = (Singleton03) constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(singleton01.hashCode());
        System.out.println(singleton02.hashCode());
    }


}
