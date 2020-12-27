package com.holddie.design.pattern.p3behavior.observer.simple.observer;

/**
 * 监听者
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/8 9:51
 */
public class Follower implements IObserver {

    private String followerName;

    public Follower(String followerName) {
        this.followerName = followerName;
    }

    @Override
    public void update(String oaName, String s) {
        System.out.println(followerName + " has received " + oaName + "'s article: " + s);
    }

    @Override
    public String toString() {
        return "Follower{" +
                "followerName='" + followerName + '\'' +
                '}';
    }
}
