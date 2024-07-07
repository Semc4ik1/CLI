package ru.gumenuk;

import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            Parser parser = Parser.getInstance(args);
            String input = parser.getInputFile();
            String output = parser.getOutputFile();

            Reader reader;
            if (input == null) {
                LOGGER.info("Не указан путь к файлу ввода, переходим на консоль");
                reader = new ConsoleReader();
            } else {
                reader = new FileReader(input);
            }
            Printer printer;
            if (output == null) {
                LOGGER.info("Не указан файл вывода, переходим на консоль");
                printer = new ConsolePrinter();
            } else {
                printer = new FilePrinter(output);
            }

            List<String> lines = reader.read();

            QuickSort<String> quickSort = new QuickSort<>();
            quickSort.sort(lines);
            LOGGER.info("Сортировка прошла успешно");
            printer.println(lines);

        } catch (ParseException e) {
            LOGGER.error("Произошла ошибка: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}