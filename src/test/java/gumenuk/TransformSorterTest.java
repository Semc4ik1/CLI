package gumenuk;

import org.junit.jupiter.api.Test;
import ru.gumenuk.options.SortDataType;
import ru.gumenuk.util.TransformSorter;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformSorterTest {
    @Test
    void transformSort_ShouldConvertAndSortIntegersInAscendingOrder() {
        List<String> integersAsString = Arrays.asList("5", "3", "8", "1", "6", "2", "7", "4");
        TransformSorter transformSorter = new TransformSorter();
        List<String> sortedIntegers = transformSorter.sort(SortDataType.INTEGER, integersAsString);
        List<Integer> expectedSortedIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(expectedSortedIntegers.size(), sortedIntegers.size());

    }

    @Test
    void transformSort_ShouldConvertAndSortDoublesInAscendingOrder() {
        List<String> integersAsString = Arrays.asList("5", "3", "8", "1", "6", "2", "7", "4");
        TransformSorter transformSorter = new TransformSorter();
        List<String> sortedIntegers = transformSorter.sort(SortDataType.DOUBLE, integersAsString);
        List<Integer> expectedSortedIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertEquals(expectedSortedIntegers.size(), sortedIntegers.size());

    }

    @Test
    void transformSort_ShouldSortStringAlphabetically() {
        List<String> strings = Arrays.asList("Banana", "Apple", "Elderberry", "Date", "Cherry");
        TransformSorter transformSorter = new TransformSorter();
        List<String> sortedStrings = transformSorter.sort(SortDataType.STRING, strings);
        List<String> expectedSortedStrings = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");
        assertEquals(expectedSortedStrings, sortedStrings);
    }

}
