package ru.gumenuk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FilePrinter implements Printer {
    private static final Logger LOGGER = LogManager.getLogger(FilePrinter.class);
    private final String filename;

    public FilePrinter(String filename) {
        this.filename = filename;
    }

    @Override
    public void println(List<String> lines) {
        try {
            Files.write(Path.of(filename), lines);
            LOGGER.info("Запись в файл прошла успешно");
        } catch (IOException e) {
            LOGGER.error("Произошла ошибка при выводе в файл: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
