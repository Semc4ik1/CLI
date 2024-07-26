package ru.gumenuk;

import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.gumenuk.options.ParseParameters;
import ru.gumenuk.options.Parser;
import ru.gumenuk.options.SortDataType;
import ru.gumenuk.util.QuickSort;
import ru.gumenuk.printer.ConsolePrinter;
import ru.gumenuk.printer.FilePrinter;
import ru.gumenuk.printer.Printer;
import ru.gumenuk.reader.ConsoleReader;
import ru.gumenuk.reader.FileReader;
import ru.gumenuk.reader.Reader;
import ru.gumenuk.util.TransformSorter;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            Parser parser = Parser.getInstance(args);
            ParseParameters parseParameters = parser.parse();

            Reader reader;
            if (parseParameters.getInputFileName() == null) {
                LOGGER.info("Не указан путь к файлу ввода, переходим на консоль");
                reader = new ConsoleReader();
            } else {
                reader = new FileReader(parseParameters.getInputFileName());
            }
            Printer printer;
            if (parseParameters.getOutputFileName() == null) {
                LOGGER.info("Не указан файл вывода, переходим на консоль");
                printer = new ConsolePrinter();
            } else {
                printer = new FilePrinter(parseParameters.getOutputFileName());
            }

            List<String> lines = reader.read();

            TransformSorter transformSorter = new TransformSorter();
            //Вместо sorted был lines
            List<String> sorted = transformSorter.sort(parseParameters.getDataType(), lines);
          //  transformSorter.sort(parseParameters.getDataType(), lines);
            LOGGER.info("Сортировка прошла успешно");
            printer.println(sorted);

        } catch (ParseException e) {
            LOGGER.error("Произошла ошибка: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

