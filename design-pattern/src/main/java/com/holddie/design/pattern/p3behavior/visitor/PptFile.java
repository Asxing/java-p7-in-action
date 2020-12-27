package com.holddie.design.pattern.p3behavior.visitor;

public class PptFile extends ResourceFile {
	public PptFile(String s) {
		super(s);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitor(this);
	}
}
