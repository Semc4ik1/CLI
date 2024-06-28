package ru.gumenuk;

import org.apache.commons.cli.*;

public class Parser {

    private static final Parser INSTANCE = new Parser();
    private final  Options options;
    private Parser() {
        options = new Options();
        options.addOption("i", "input", false, "Файл ввода");
        options.addOption("o", "output", false, "Файл вывода");

    }

    public static Parser getInstance() {
        return INSTANCE;
    }
    public String getInputFile(String[] args){
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);

            if(cmd.hasOption("i")){
                return cmd.getOptionValue("i");
            }else {
                throw new Exception("Нет опции i");
            }

        } catch (Exception e) {
            System.err.println("Ошибка при разборе аргументов");
            System.err.println(e.getMessage());
            throw new RuntimeException("Ошибка при разборе аргументов: " + e.getMessage());
        }
    }
    public String getOutputFile(String[] args){
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);

            if(cmd.hasOption("o")){
                return cmd.getOptionValue("o");
            } else {
                throw new Exception("Опция 'o' не указана");
            }

        } catch (Exception e) {
            System.err.println("Ошибка при разборе аргументов");
            System.err.println(e.getMessage());
            throw new RuntimeException("Ошибка при разборе аргументов: " + e.getMessage());
        }
    }
    public String[] getInputFileNames(String[] args) throws ParseException {
        CommandLineParser cmdParser = new DefaultParser();
        CommandLine cmd = cmdParser.parse(options, args);
        return cmd.getOptionValues("-i");
    }
    public String getOutputFileName(String[] args) throws ParseException {
        CommandLineParser cmdParser = new DefaultParser();
        CommandLine cmd = cmdParser.parse(options, args);
        return cmd.getOptionValue("-o");
    }



}
