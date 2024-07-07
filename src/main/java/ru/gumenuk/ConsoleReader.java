package ru.gumenuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleReader implements Reader {
    private static final Logger LOGGER = LogManager.getLogger(ConsoleReader.class);

    @Override
    public List<String> read() {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            LOGGER.info("Введите строки в консоль");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                lines.add(line);
            }
            LOGGER.info("Введеные данные считаны");
        }
        return lines;
    }
}
