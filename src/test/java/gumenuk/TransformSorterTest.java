package gumenuk;

import org.junit.jupiter.api.Test;
import ru.gumenuk.options.SortDataType;
import ru.gumenuk.util.TransformSorter;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TransformSorterTest {
    @Test
    void transformSort_ShouldConvertAndSortIntegersInAscendingOrder() {
        List<String> integersAsString = Arrays.asList("5", "3", "8", "1", "6", "2", "7", "4");
        TransformSorter transformSorter = new TransformSorter();
        List<String> sortedIntegers = transformSorter.sort(SortDataType.INTEGER, integersAsString);
        List<String> expectedSortedIntegers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
        assertEquals(expectedSortedIntegers.size(), sortedIntegers.size());
        assertArrayEquals(expectedSortedIntegers.toArray(), sortedIntegers.toArray());

    }

    @Test
    void transformSort_ShouldConvertAndSortDoublesInAscendingOrder() {
        List<String> doublesAsString = Arrays.asList("5.0", "3.0", "8.0", "1.0", "6.0", "2.0", "7.0", "4.0");
        TransformSorter transformSorter = new TransformSorter();
        List<String> sortedDoubles = transformSorter.sort(SortDataType.DOUBLE, doublesAsString);
        List<String> expectedSortedDoubles = Arrays.asList("1.0", "2.0", "3.0", "4.0", "5.0", "6.0", "7.0", "8.0");
        assertEquals(expectedSortedDoubles.size(), sortedDoubles.size());
        assertArrayEquals(expectedSortedDoubles.toArray(), sortedDoubles.toArray());
    }

    @Test
    void transformSort_ShouldSortStringAlphabetically() {
        List<String> strings = Arrays.asList("Banana", "Apple", "Elderberry", "Date", "Cherry");
        TransformSorter transformSorter = new TransformSorter();
        List<String> sortedStrings = transformSorter.sort(SortDataType.STRING, strings);
        List<String> expectedSortedStrings = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");
        assertEquals(expectedSortedStrings.size(), sortedStrings.size());
        assertArrayEquals(expectedSortedStrings.toArray(), sortedStrings.toArray());
    }

}
