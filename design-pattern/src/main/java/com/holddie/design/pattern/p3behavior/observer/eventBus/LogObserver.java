package com.holddie.design.pattern.p3behavior.observer.eventBus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LogObserver {

    @Subscribe
    public void handle(String log) {
        System.out.println("LogObserver log : " + log);
    }
}
