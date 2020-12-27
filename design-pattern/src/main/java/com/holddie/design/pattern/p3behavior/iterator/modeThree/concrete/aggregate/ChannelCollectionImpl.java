package com.holddie.design.pattern.p3behavior.iterator.modeThree.concrete.aggregate;


import com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate.Channel;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate.ChannelCollection;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate.ChannelTypeEnum;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.concrete.iterator.ChannelIteratorImpl;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.iterator.ChannelIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 频道集合实现类
 *
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/6 9:01
 */
public class ChannelCollectionImpl implements ChannelCollection {

    private List<Channel> channelList;

    public ChannelCollectionImpl() {
        channelList = new ArrayList<>();
    }

    @Override
    public void addChannel(Channel channel) {
        this.channelList.add(channel);
    }

    @Override
    public void removeChannel(Channel channel) {
        this.channelList.remove(channel);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum typeEnum) {
        return new ChannelIteratorImpl(typeEnum, this.channelList);
    }
}
