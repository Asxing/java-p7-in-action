package com.holddie.design.pattern.p1creation.c02factory.factoryMethod;


/**
 * 工厂方法，
 * 对于每一个实例会有一个对应的Factory与之对应，只关注自己的对应的类
 * 之后的扩展对于原先的代码没有改动，只需要进行继承和修改之后，就可以new创建了
 *
 *
 * 工厂方法：顾名思义就是使用方法进行工厂的区分
 *
 * 优点：
 * 遵循OCP，
 * 易于单元测试
 * 逻辑解耦
 * 公共制造逻辑可以抽取到抽象类中
 *
 *
 * Spring容器基于工厂模式
 * 创建Springbeans
 * 管理SpringBeans生命周期
 *
 * 工厂接口：
 * BeanFactory
 * ApplicationContext
 *
 * 工厂方法：
 * getBean
 */
