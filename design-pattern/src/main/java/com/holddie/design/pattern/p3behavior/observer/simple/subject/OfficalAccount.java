package com.holddie.design.pattern.p3behavior.observer.simple.subject;



import com.holddie.design.pattern.p3behavior.observer.simple.observer.IObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题具体实现
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/6/8 9:47
 */
public class OfficalAccount implements ISubject {

    private String oaName;

    private List<IObserver> followers;

    public OfficalAccount(String oaName) {
        this.oaName = oaName;
        followers = new ArrayList<>();
    }

    @Override
    public void register(IObserver observer) {
        followers.add(observer);
        System.out.println(observer + " has started following " + oaName);
    }

    @Override
    public void unregister(IObserver observer) {
        followers.remove(observer);
        System.out.println(observer + "has stopped following " + oaName);
    }

    @Override
    public void notifyAllObserver(String s) {
        for (IObserver follower :
                followers) {
            follower.update(oaName, s);
        }
        System.out.println("notify update.............");
    }

    public void pushArticle(String article) {
        System.out.println("\n" + oaName + " has pushed :: " + article);
        notifyAllObserver(article);
    }
}
