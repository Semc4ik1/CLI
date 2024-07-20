package gumenuk;

import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;
import ru.gumenuk.options.Parser;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    void parse_testParsingFilePathsIsCorrect() throws ParseException {
        String[] args = {"-i", "input.txt", "-o", "output.txt"};
        Parser parser = Parser.getInstance(args);
        assertNotNull(parser.getInputFile());
        assertEquals("input.txt", parser.getInputFile());
        assertNotNull(parser.getOutputFile());
        assertEquals("output.txt", parser.getOutputFile());
    }
    @Test
    void parse_SingleParameter() throws ParseException {
        String[] args = {"-i", "input.txt"};

        Parser parser = Parser.getInstance(args);

        String inputFile = parser.getInputFile();
        assertNotNull(inputFile);
        assertEquals("input.txt", inputFile);

        String outputFile = parser.getOutputFile();
        assertNull(outputFile);
    }
    @Test
    void parse_NoParameters() throws ParseException {
        String[] args = {};

        Parser parser = Parser.getInstance(args);

        String inputFile = parser.getInputFile();
        assertNull(inputFile);

        String outputFile = parser.getOutputFile();
        assertNull(outputFile);
    }
    @Test
    void parse_DuplicateOptions() throws ParseException {
        String[] args = {"-i", "input.txt", "-i", "input2.txt"};

        Parser parser = Parser.getInstance(args);

        String inputFile = parser.getInputFile();
        assertNotNull(inputFile);
        assertEquals("input.txt", parser.getInputFile());

        String outputFile = parser.getOutputFile();
        assertNotNull(outputFile);
        assertEquals("input2.txt", parser.getOutputFile());
    }
    @Test
    void parse_MultipleOptions() throws ParseException {
        String[] args = {"-i", "input1.txt", "-o", "output1.txt", "-e", "input2.txt", "-d", "output2.txt"};

        Parser parser = Parser.getInstance(args);

        String inputFile1 = parser.getInputFile();
        assertNotNull(inputFile1);
        assertEquals("input1.txt", parser.getInputFile());

        String outputFile1 = parser.getOutputFile();
        assertNotNull(outputFile1);
        assertEquals("output1.txt",parser.getOutputFile() );

        String inputFile2 = parser.getInputFile();
        assertNotNull(inputFile2);
        assertEquals("input2.txt", parser.getInputFile());

        String outputFile2 = parser.getOutputFile();
        assertNotNull(outputFile2);
        assertEquals("output2.txt", parser.getOutputFile());
    }
    @Test
    void parse_MultipleFilesForSameOption() throws ParseException {
        String[] args = {"-i", "input1.txt input2.txt input3.txt input4.txt"};
        Parser parser = Parser.getInstance(args);

        String inputFile1 = parser.getInputFile();
        assertNotNull(inputFile1);
        assertEquals("input1.txt", inputFile1);

        String inputFile2 = parser.getInputFile();
        assertNotNull(inputFile2);
        assertEquals("input2.txt", inputFile2);

        String inputFile3 = parser.getInputFile();
        assertNotNull(inputFile3);
        assertEquals("input3.txt", inputFile3);

        String inputFile4 = parser.getInputFile();
        assertNotNull(inputFile4);
        assertEquals("input4.txt", inputFile4);
    }

}
