package com.holddie.design.pattern.p3behavior.visitor;

public class Compressor implements Visitor {
    @Override
    public void visitor(PdfFile pdfFile) {
        System.out.println("Compress PDF");
    }

    @Override
    public void visitor(PptFile pptFile) {
        System.out.println("Compress PPT");
    }

    @Override
    public void visitor(WordFile wordFile) {
        System.out.println("Compress Word");
    }
}
