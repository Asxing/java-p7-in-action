package com.holddie.design.pattern.p3behavior.visitor;

public class WordFile extends ResourceFile {
    public WordFile(String s) {
        super(s);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}
