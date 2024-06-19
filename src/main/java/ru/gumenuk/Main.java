package ru.gumenuk;
import org.apache.commons.cli.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class Main {
    private static final Option INPUT_OPTION = new Option("i", "input", true, "Файл ввода");
    private static final Option OUTPUT_OPTION = new Option("o", "output", true, "Файл вывода");
    private static final Option DIVIDE_OPTION = new Option("e", "divide", false, "Выполнить действие");

    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        PrintWriter pw = new PrintWriter(System.out);
        pw.println();
        formatter.printUsage(pw, 100, "java -jar java_starter.jar [options]");
        formatter.printOptions(pw, 100, options, 2, 5);
        pw.close();
    }

    private static List<String> readList(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    private static void writeList(String filename, List<String> list) throws IOException {
        Files.write(Path.of(filename), list);
    }

    public static void main(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption(INPUT_OPTION);
        options.addOption(OUTPUT_OPTION);
        options.addOption(DIVIDE_OPTION);

        try {
            CommandLine cmd = parser.parse(options, args);
            if (!(cmd.hasOption(INPUT_OPTION) && cmd.hasOption(OUTPUT_OPTION))) {
                printHelp(options);
                System.exit(-1);
            }
            int a = 0;
            int b = 0;
            try {
                a = Integer.parseInt(cmd.getArgList().get(0));
                b = Integer.parseInt(cmd.getArgList().get(1));
            } catch (Exception e) {
                System.out.println(options);
                System.exit(-1);
            }

            if (cmd.hasOption(DIVIDE_OPTION)) {
                System.out.println(a / b);
            } else {
                System.out.println("Операция деления не запрошена.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
