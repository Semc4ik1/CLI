package ru.gumenuk;

import org.apache.commons.cli.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = Parser.getInstance();

        try {

            String inputFileName = String.valueOf(parser.getInputFileNames(args).getClass());
            String outputFileName = parser.getOutputFileName(args);


            FileReader reader = new FileReader(inputFileName);
            FilePrinter writer = new FilePrinter(outputFileName);


            List<String> lines = reader.read(inputFileName);
            String contentToWrite = String.join(System.lineSeparator(), lines);
            writer.println(outputFileName, lines);

        } catch (ParseException e) {
            System.err.println("Ошибка при разборе аргументов или работе с файлами: " + e.getMessage());
        }
    }
}
