package com.holddie.design.pattern.p3behavior.visitor;

public interface Visitor {
	void visitor(PdfFile pdfFile);

	void visitor(PptFile pptFile);

	void visitor(WordFile wordFile);
}
