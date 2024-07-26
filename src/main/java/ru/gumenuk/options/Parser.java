package ru.gumenuk.options;

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
                .option(CliOption.INPUT.getShortOption())
                .hasArg()
                .desc(CliOption.INPUT.getDescription())
                .longOpt(CliOption.INPUT.getLongOption())
                .numberOfArgs(1)
                .build();
        Option outputOption = Option.builder()
                .option(CliOption.OUTPUT.getShortOption())
                .hasArg()
                .desc(CliOption.OUTPUT.getDescription())
                .longOpt(CliOption.OUTPUT.getLongOption())
                .numberOfArgs(1)
                .build();
        Option stringOption = Option.builder()
                .option(CliOption.STRING.getShortOption())
                .desc(CliOption.STRING.getDescription())
                .longOpt(CliOption.STRING.getLongOption())
                .build();
        Option integerOption = Option.builder()
                .option(CliOption.INTEGER.getShortOption())
                .desc(CliOption.INTEGER.getDescription())
                .longOpt(CliOption.INTEGER.getLongOption())
                .build();
        Option doubleOption = Option.builder()
                .option(CliOption.DOUBLE.getShortOption())
                .desc(CliOption.DOUBLE.getDescription())
                .longOpt(CliOption.DOUBLE.getLongOption())
                .build();
        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(stringOption);
        optionGroup.addOption(integerOption);
        optionGroup.addOption(doubleOption);
        options.addOptionGroup(optionGroup);
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

    public ParseParameters parse(){
        ParseParameters params = new ParseParameters();
        if(cmd.hasOption(CliOption.INTEGER.getLongOption())){
            params.setDataType(SortDataType.INTEGER);
        }
        if(cmd.hasOption(CliOption.STRING.getLongOption())){
            params.setDataType(SortDataType.STRING);
        }
        if(cmd.hasOption(CliOption.DOUBLE.getLongOption())){
            params.setDataType(SortDataType.DOUBLE);
        }
        params.setInputFileName(cmd.getOptionValue("i"));
        params.setOutputFileName(cmd.getOptionValue("o"));
        return params;
    }


}
