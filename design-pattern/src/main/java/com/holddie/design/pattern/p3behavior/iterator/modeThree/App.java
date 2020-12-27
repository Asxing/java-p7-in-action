package com.holddie.design.pattern.p3behavior.iterator.modeThree;

import com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate.Channel;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate.ChannelCollection;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.aggregate.ChannelTypeEnum;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.concrete.aggregate.ChannelCollectionImpl;
import com.holddie.design.pattern.p3behavior.iterator.modeThree.iterator.ChannelIterator;

/** Hello world! */
public class App {

    private static ChannelCollection populateChannel() {
        ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(99.5, ChannelTypeEnum.CHINESE));
        channels.addChannel(new Channel(100.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(101.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(102.5, ChannelTypeEnum.CHINESE));
        channels.addChannel(new Channel(103.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(105.5, ChannelTypeEnum.CHINESE));
        channels.addChannel(new Channel(106.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(107.5, ChannelTypeEnum.FRENCH));
        return channels;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ChannelCollection collections = populateChannel();
        ChannelIterator channelIterator = collections.iterator(ChannelTypeEnum.ALL);
        while (channelIterator.hasNext()) {
            Channel channel = channelIterator.next();
            System.out.println(channel);
        }
        System.out.println("----second print----");
        while (channelIterator.hasNext()) {
            Channel channel = channelIterator.next();
            System.out.println(channel);
        }
        System.out.println("------------------------------------------------");

        ChannelIterator channelIterator1 = collections.iterator(ChannelTypeEnum.ENGLISH);
        while (channelIterator1.hasNext()) {
            Channel channel = channelIterator1.next();
            System.out.println(channel);
        }
    }
}
