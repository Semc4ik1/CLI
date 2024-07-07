package ru.gumenuk;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parser {
    private static final Logger LOGGER = LogManager.getLogger(Parser.class);
    private static Parser INSTANCE;
    private final CommandLine cmd;

    private Parser(String[] args) throws ParseException {
        Options options = new Options();
        Option inputOption = Option.builder()
                .option("i")
                .hasArg()
                .desc("Файл ввода")
                .longOpt("input")
                .numberOfArgs(1)
                .build();
        Option outputOption = Option.builder()
                .option("o")
                .hasArg()
                .desc("Файл вывода")
                .longOpt("output")
                .numberOfArgs(1)
                .build();
        options.addOption(inputOption);
        options.addOption(outputOption);
        CommandLineParser commandLineParser = new DefaultParser();
        cmd = commandLineParser.parse(options, args);
        LOGGER.info("Удалось распарсить командную строку");
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
