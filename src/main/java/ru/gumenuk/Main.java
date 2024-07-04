package ru.gumenuk;

import org.apache.commons.cli.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Parser parser = Parser.getInstance(args);
            String input = parser.getInputFile();
            String output = parser.getOutputFile();
            Reader reader = new FileReader(input);
            Printer printer = new FilePrinter(output);

            List<String> lines = reader.read();

            QuickSort<String> quickSort = new QuickSort<>();
            quickSort.sort(lines);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
