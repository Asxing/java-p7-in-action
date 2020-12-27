package com.holddie.design.pattern.p3behavior.iterator.modeThree.concrete.iterator;


import com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate.Channel;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate.ChannelTypeEnum;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.iterator.ChannelIterator;

import java.util.List;


/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/6 9:04
 */
public class ChannelIteratorImpl implements ChannelIterator {

    private ChannelTypeEnum typeEnum;

    private List<Channel> channelList;

    private int position;

    public ChannelIteratorImpl(ChannelTypeEnum typeEnum, List<Channel> channelList) {
        this.typeEnum = typeEnum;
        this.channelList = channelList;
    }

    @Override
    public boolean hasNext() {
        while (position < channelList.size()) {
            Channel c = channelList.get(position);
            if (c.getTypeEnum().equals(typeEnum) || typeEnum.equals(ChannelTypeEnum.ALL)) {
                return true;
            } else {
                position++;
            }
        }
        return false;
    }

    @Override
    public Channel next() {
        Channel c = channelList.get(position);
        position++;
        return c;
    }
}
