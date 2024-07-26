package ru.gumenuk.comparator;

import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {

    @Override
    public int compare(Double o1, Double o2) {
        return Double.compare(o1, o2);
    }
}
