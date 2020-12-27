package com.holddie.design.pattern.p3behavior.visitor;

import java.util.ArrayList;
import java.util.List;

public class ToolApplication {
    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        List<ResourceFile> list = listAllResourceFiles(args[0]);
        for (ResourceFile resourceFile : list) {
            resourceFile.accept(extractor);
        }

        Compressor compressor = new Compressor();
        list.forEach(
                resourceFile -> {
                    resourceFile.accept(compressor);
                });
    }

    private static List<ResourceFile> listAllResourceFiles(String arg) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new PptFile("a.ppt"));
        resourceFiles.add(new WordFile("a.word"));
        return resourceFiles;
    }
}
