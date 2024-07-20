package ru.gumenuk;

import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.gumenuk.options.ParseParameters;
import ru.gumenuk.options.Parser;
import ru.gumenuk.util.QuickSort;
import ru.gumenuk.printer.ConsolePrinter;
import ru.gumenuk.printer.FilePrinter;
import ru.gumenuk.printer.Printer;
import ru.gumenuk.reader.ConsoleReader;
import ru.gumenuk.reader.FileReader;
import ru.gumenuk.reader.Reader;

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

            //   QuickSort<String> quickSort = new QuickSort<>();
            QuickSort.sort(lines);
            LOGGER.info("Сортировка прошла успешно");
            printer.println(lines);

        } catch (ParseException e) {
            LOGGER.error("Произошла ошибка: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

//Добавить в ютил новый класс название TransformSorter внутри я делаю метод sort и он будет принимать List<String>, и он будет принимать
//обьект sortDataType
// в этом классе я создаю конвертер по пришедшему сорт дата тайп (если интегер пришел то создаю интегер и так далее)
// по пришедшему типу создать компаратор integer comparator и так далее
// List стрингов переделываю в нужный тип с помощью конвертера и сортирую с помощью метода сорт класса quicksort и вернуть сортированный список