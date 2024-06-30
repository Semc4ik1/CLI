package ru.gumenuk;

import org.apache.commons.cli.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            Parser parser = Parser.getInstance(args);
            String input = parser.getInputFile();
            String output = parser.getOutputFile();
            Reader reader = new FileReader(input);
            Printer printer = new FilePrinter(output);
            printer.println(reader.read());
        } catch (ParseException e) {
            //Вывести в лог сообщение и да и хуй с ним
            throw new RuntimeException(e);
        }

    }
}
