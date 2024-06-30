package ru.gumenuk;

import org.apache.commons.cli.*;

public class Parser {

    private static Parser INSTANCE;
    private final CommandLine cmd;

    private Parser(String[] args) throws ParseException {
        Options options = new Options();
        Option inputOption = Option.builder()
                .option("i")
                .hasArg()
                .desc("Файл ввода")
                .required()
                .longOpt("input")
                .numberOfArgs(1)
                .build();
        Option outputOption = Option.builder()
                .option("o")
                .hasArg()
                .desc("Файл вывода")
                .required()
                .longOpt("output")
                .numberOfArgs(1)
                .build();
        options.addOption(inputOption);
        options.addOption(outputOption);
        CommandLineParser commandLineParser = new DefaultParser();
        cmd = commandLineParser.parse(options, args);
    }


    public static synchronized Parser getInstance(String[] args) throws ParseException {
        if (INSTANCE == null) {
            INSTANCE = new Parser(args);
        }
        return INSTANCE;
    }

    public String getInputFile() {
        return cmd.getOptionValue("i");
    }

    public String getOutputFile() {
        return cmd.getOptionValue("o");
    }


}
