package ru.gumenuk.util;

import java.util.Comparator;
import java.util.List;

public final class QuickSort {

    private QuickSort() {
        throw new UnsupportedOperationException();
    }

    public static<T> void sort(List<T> list, Comparator<T> comparator) {
        quickSort(list, 0, list.size() - 1, comparator);
    }

    private static<T> void quickSort(List<T> list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(list, low, high, comparator);

            quickSort(list, low, pi - 1, comparator);
            quickSort(list, pi + 1, high, comparator);
        }
    }

    private static<T> int partition(List<T> list, int low, int high, Comparator<T> comparator) {
        T pivot = list.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if ( comparator.compare(list.get(j), pivot) <= 0) {
                i++;


                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }


        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}
