package gumenuk;

import org.junit.jupiter.api.Test;

import ru.gumenuk.comparator.IntegerComparator;
import ru.gumenuk.comparator.StringComparator;
import ru.gumenuk.util.QuickSort;

import java.util.Arrays;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void quickSort_allEmptyStringsShouldRemainUnchanged() {
        List<String> emptyStrings = Arrays.asList("", "", "", "");
        StringComparator stringComparator = new StringComparator();
        QuickSort.sort(emptyStrings, stringComparator);
        List<String> expectedResult = Arrays.asList("", "", "", "");
        assertArrayEquals(expectedResult.toArray(), emptyStrings.toArray());
    }

    @Test
    void quickSort_shouldMustBeSortedInAscendingOrder() {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 6, 2, 7, 4);
        IntegerComparator integerComparator = new IntegerComparator();
        QuickSort.sort(numbers, integerComparator);
        List<Integer> expectedSortedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertArrayEquals(expectedSortedNumbers.toArray(), numbers.toArray());
    }

    @Test
    void quickSort_duplicateShouldRemainsInPlace() {
        List<Integer> numbers = Arrays.asList(1, 3, 2, 5, 6, 4, 3, 3);
        IntegerComparator integerComparator = new IntegerComparator();
        QuickSort.sort(numbers, integerComparator);
        List<Integer> expectedSortedNumbers = Arrays.asList(1, 2, 3, 3, 3, 4, 5, 6);
        assertArrayEquals(expectedSortedNumbers.toArray(), numbers.toArray());
    }

    @Test
    void quickSort_negativeNumbersShouldBeInAscendingOrder() {
        List<Integer> numbers = Arrays.asList(-5, -3, -8, -1, -6, -2, -7, -4);
        IntegerComparator integerComparator = new IntegerComparator();
        QuickSort.sort(numbers, integerComparator);
        List<Integer> expectedSortedNumbers = Arrays.asList(-8, -7, -6, -5, -4, -3, -2, -1);
        assertArrayEquals(expectedSortedNumbers.toArray(), numbers.toArray());
    }

    @Test
    void quickSort_testStringShouldMustBeInAlphabeticalOrder() {

        List<String> strings = Arrays.asList("Banana", "Apple", "Elderberry", "Date", "Cherry");
        StringComparator stringComparator = new StringComparator();
        QuickSort.sort(strings, stringComparator);
        List<String> expectedSortedStrings = List.of("Apple", "Banana", "Cherry", "Date", "Elderberry");
        assertArrayEquals(expectedSortedStrings.toArray(), strings.toArray());
    }
}
