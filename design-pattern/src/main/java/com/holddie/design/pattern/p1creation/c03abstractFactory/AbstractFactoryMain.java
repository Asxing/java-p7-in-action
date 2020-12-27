package com.holddie.design.pattern.p1creation.c03abstractFactory;

/**
 * 抽象工厂实现类
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/23 9:30
 */
public class AbstractFactoryMain {

    public static void main(String[] args) {
        IElectricalFactory chineseElectricalFactory = new ChineseElectricalFactory();

        IFan chineseFan = chineseElectricalFactory.createFan();

        ITubeLight chineseTubeLight = chineseElectricalFactory.createTubeLight();

        chineseFan.switchOff();
        chineseTubeLight.turnOn();


        IElectricalFactory usElectricalFactory = new UsElectricalFactory();
        IFan usFan = usElectricalFactory.createFan();
        ITubeLight usTubeLight = usElectricalFactory.createTubeLight();

        usFan.switchOff();
        usTubeLight.turnOn();
    }
}



