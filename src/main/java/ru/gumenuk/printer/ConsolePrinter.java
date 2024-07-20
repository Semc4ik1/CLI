package ru.gumenuk.printer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ConsolePrinter implements Printer {
    private static final Logger LOGGER = LogManager.getLogger(ConsolePrinter.class);

    @Override
    public void println(List<String> lines) {
        for (String line : lines) {
            System.out.println(line);
        }
        LOGGER.info("Попытка записи прошла успешно");
    }
}

