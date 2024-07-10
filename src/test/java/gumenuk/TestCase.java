package gumenuk;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.gumenuk.Parser;
import ru.gumenuk.QuickSort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCase {
    @Test
    public void quickSort_shouldReturnTrue_stringListIsEmpty(){
        QuickSort<String> quickSort = new QuickSort<>();
        List<String> list = new ArrayList<>();
        quickSort.sort(list);
        assertTrue(list.isEmpty(), "Коллекция должна остаться пустой");
    }
    @Test
    public void quickSort_shouldReturnTrue_integerListIsSorted(){
        List<Integer> list = new ArrayList<>(List.of(2, 75, 1000, 54, 200));
        List<Integer> expected = List.of(2, 54, 75, 200, 1000);
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(list);

        Assertions.assertArrayEquals(expected.toArray(), list.toArray());
    }
    @Test
    public void parse_ShouldReturnTrue_filePathIsCorrect() throws ParseException {
        String[] args = {"-i", "/path/to/input", "-o", "/path/to/output"};
        Parser parser = Parser.getInstance(args);
        assertNotNull(parser.getInputFile());
        assertEquals("/path/to/input", parser.getInputFile());
        assertNotNull(parser.getOutputFile());
        assertEquals("/path/to/output", parser.getOutputFile());
    }
    @Test
    public void quickSort_shouldReturnFalse_stringListIsEmpty(){
        QuickSort<String> quickSort = new QuickSort<>();
        List<String> list = new ArrayList<>();
        quickSort.sort(list);
        assertFalse(list.isEmpty(), "Коллекция не должна остаться пустой");
    }

}
