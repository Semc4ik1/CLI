package gumenuk;

import org.junit.jupiter.api.Test;

import ru.gumenuk.util.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.sort;
import static org.junit.jupiter.api.Assertions.*;

 class QuickSortTest {
    @Test
     void quickSort_stringListShouldIsEmpty(){
        QuickSort<String> quickSort = new QuickSort<>();
        List<String> list = new ArrayList<>();
        quickSort.sort(list);
        assertTrue(list.isEmpty());
    }
    @Test
     void quickSort_shouldMustBeSortedInAscendingOrder(){
        List<Integer> list = new ArrayList<>(List.of(2, 75, 1000, 54, 200));
        List<Integer> expected = List.of(2, 54, 75, 200, 1000);
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(list);

        assertArrayEquals(expected.toArray(), list.toArray());
    }
    @Test
    void quickSort_duplicateShouldRemainsInPlace(){
       List<Integer> duplicatesList = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5));
       sort(duplicatesList);

       assertEquals(Arrays.asList(5, 5, 5, 5, 5), duplicatesList);
    }
    @Test
    void quickSort_negativeNumbersShouldBeInAscendingOrder(){
       List<Integer> negativeNumbersList = new ArrayList<>(Arrays.asList(-5, -8, -1, -6, -3, -7, -2, -4));
       sort(negativeNumbersList);

       assertEquals(Arrays.asList(-8, -7, -6, -5, -4, -3, -2, -1), negativeNumbersList );
    }
    @Test
    public void quickSort_testStringShouldMustBeInAlphabeticalOrder() {
       List<String> testStrings = Arrays.asList("Banana", "Apple", "Elderberry", "Date", "Cherry");
       sort(testStrings);
       assertEquals(Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry"), testStrings);
    }
}
