package ru.gumenuk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader implements Reader {
    private final String filename;

    public FileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> read(String container) {
        try {
            return Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
