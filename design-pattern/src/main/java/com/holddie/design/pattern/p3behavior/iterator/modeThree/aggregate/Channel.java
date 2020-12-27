package com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate;

import lombok.Data;

/**
 * 循环后获得的实体
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/6 8:55
 */
@Data
public class Channel {

    private double frequency;

    private ChannelTypeEnum typeEnum;

    public Channel(double frequency, ChannelTypeEnum typeEnum) {
        this.frequency = frequency;
        this.typeEnum = typeEnum;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "frequency=" + frequency +
                ", typeEnum=" + typeEnum +
                '}';
    }
}
