package ru.gumenuk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderSystem implements Reader {
    private final String filename;

    public FileReaderSystem(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> read() {
        try {
            Path filePath = Path.of(filename);
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + e.getMessage(), e);
        }
    }
}
