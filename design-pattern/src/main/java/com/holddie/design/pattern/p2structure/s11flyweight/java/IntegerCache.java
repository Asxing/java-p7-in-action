package com.holddie.design.pattern.p2structure.s11flyweight.java;

import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.WeakHashMap;

public class IntegerCache {
	public static final WeakHashMap<Integer, WeakReference<Integer>> cache = new WeakHashMap<>();

	private IntegerCache() {
	}

	public static Integer valueOf(int i) {
		final WeakReference<Integer> cached = IntegerCache.cache.get(i);
		if (Objects.nonNull(cached)) {
			final Integer value = cached.get();
			if (Objects.nonNull(value)) {
				return value;
			}
		}
		WeakReference<Integer> val = new WeakReference<>(i);
		IntegerCache.cache.put(i, val);
		return val.get();
	}
}
