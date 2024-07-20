package ru.gumenuk.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader implements Reader {
    private final String filename;
    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

    public FileReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> read() {
        try {
            LOGGER.info("Происходит попытка считывания");
            return Files.readAllLines(Path.of(filename));
        } catch (IOException e) {
            LOGGER.error("Произошла ошибка считывания из файла: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
