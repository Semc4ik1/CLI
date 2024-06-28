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
    public void println(String content, List<String> lines)  {
        try {
            Files.writeString(Path.of(filename), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void error(String error) {
        try {
            Files.writeString(Path.of(filename), "[ERROR]: " + error);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}


