package com.holddie.design.pattern.p3behavior.interpreter.demo2;

import java.util.HashMap;
import java.util.Map;

public class Demo2Test {
	public static void main(String[] args) {
		String rule = "key1 > 101 && key2 < 30 || key3 < 10 || key4 == 188";
		AlertRuleInterpreter interpreter = new AlertRuleInterpreter(rule);
		Map stats = new HashMap<>(4);
		stats.put("key1", 101l);
		stats.put("key3", 121l);
		stats.put("key4", 88l);
		boolean alert = interpreter.interpret(stats);
		System.out.println(alert);
	}
}
