/**
 * 定义： 1、提供一个接口，用于制造一族相关或者相互依赖的产品，无需指定具体的实现类
 *
 * <p>2、创建工厂的工厂
 *
 * <p>好处： 1、解耦，客户代码和具体产品解耦 2、比工厂模式更高级的设计模式 3、标准化产品构造流程 4、可以替换某个实现家族
 *
 * <p>Factorybean 接口基于抽象工厂模式： 1、ProxyFactoryBean 2、JndiFactoryBean 3、LocalSessionFactoryBean
 * 4、LocalContainerEntityManagerFactoryBean
 *
 * <p>构造具有很多依赖的复杂对象 构造逻辑易变且依赖于配置
 */
package com.holddie.design.pattern.p1creation.c03abstractFactory;
