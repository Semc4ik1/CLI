package ru.gumenuk;

import org.apache.commons.cli.ParseException;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Parser parser = Parser.getInstance(args);
            String input = parser.getInputFile();
            String output = parser.getOutputFile();
            Reader reader = new FileReader(input);
            Printer printer = new FilePrinter(output);
            QuickSort<String> quickSort = new QuickSort<>();
            List<String> lines = reader.read();
            quickSort.sort(lines);
            printer.println(reader.read());
            /*for (String line : lines) {
                printer.println(Collections.singletonList(line));
            }*/

        } catch (ParseException e) {

            throw new RuntimeException(e);
        }



    }
}
