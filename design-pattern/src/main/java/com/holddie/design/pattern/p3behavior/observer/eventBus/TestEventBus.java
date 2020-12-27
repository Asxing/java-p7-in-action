package com.holddie.design.pattern.p3behavior.observer.eventBus;


import java.util.concurrent.Executors;

public class TestEventBus {
	private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 1;

	public static void main(String[] args) {
		EventBus eventBus = new AsyncEventBus(
				Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
		LogObserver logObserver = new LogObserver();
		eventBus.register(logObserver);
		eventBus.post("123");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
