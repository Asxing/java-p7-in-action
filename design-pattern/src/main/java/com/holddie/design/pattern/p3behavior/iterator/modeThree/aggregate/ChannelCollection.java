package com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate;

import com.holddie.design.pattern.p3behavior.iterator.modeThree.iterator.ChannelIterator;

/**
 * 聚合对象
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/6 8:54
 */
public interface ChannelCollection {

    public void addChannel(Channel channel);

    public void removeChannel(Channel channel);

    public ChannelIterator iterator(ChannelTypeEnum typeEnum);
}
