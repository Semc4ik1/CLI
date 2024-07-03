package ru.gumenuk;

import java.util.List;

public class FilePrinterSystem implements Printer {
    private final String filename;
    public FilePrinterSystem(String filename) {
        this.filename = filename;
    }

    @Override
    public void println(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}

