package com.holddie.design.pattern.p3behavior.visitor;

public class Extractor implements Visitor {
    @Override
    public void visitor(PdfFile pdfFile) {
        System.out.println("Extract PDF");
    }

    @Override
    public void visitor(PptFile pptFile) {
        System.out.println("Extract PPT");
    }

    @Override
    public void visitor(WordFile wordFile) {
        System.out.println("Execute Word");
    }
}
