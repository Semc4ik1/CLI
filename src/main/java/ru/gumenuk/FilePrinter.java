package ru.gumenuk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FilePrinter implements Printer {

    private final String filename;

    public FilePrinter(String filename) {
        this.filename = filename;
    }

    @Override
    public void println(List<String> lines) {
        try {
            Files.write(Path.of(filename), lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

