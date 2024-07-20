package ru.gumenuk.util;

import ru.gumenuk.comparator.DoubleComparator;
import ru.gumenuk.comparator.IntegerComparator;
import ru.gumenuk.convert.ConvertDouble;
import ru.gumenuk.convert.ConvertInteger;
import ru.gumenuk.exception.TempConvertException;
import ru.gumenuk.options.SortDataType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TransformSorter {
    public List<String> Sort(SortDataType sortDataType, List<String> inputStrings) throws IllegalAccessException {
        switch (sortDataType) {
            case INTEGER:
                return sortIntegers(inputStrings, new IntegerComparator());
            case STRING:
                return inputStrings;
            case DOUBLE:
                return sortDoubles(inputStrings, new DoubleComparator());

            default:
                throw new IllegalAccessException("Неподдерживаемый тип данных: " + sortDataType);
        }
    }

    private List<String> sortIntegers(List<String> integersAsString, IntegerComparator comparator) {
        ConvertInteger convertInteger = new ConvertInteger();
        List<Integer> integers = new ArrayList<>();

        for (String s : integersAsString) {
            try {
                Integer integer = convertInteger.convert(s);
                integers.add(integer);
            } catch (TempConvertException e) {
                throw new RuntimeException(e);
            }
        }

        QuickSort.sort(integers, comparator);

        List<String> sortedStrings = new ArrayList<>();
        for (Integer integer : integers) {
            sortedStrings.add(String.valueOf(integer));
        }

        return sortedStrings;
    }

    private List<String> sortDoubles(List<String> doublesAsString, Comparator<Double> comparator) {
        ConvertDouble convertDouble = new ConvertDouble();
        List<Double> doubles = new ArrayList<>();

        for (String s : doublesAsString) {
            try {
                Double doubleValue = convertDouble.convert(s);
                doubles.add(doubleValue);
            } catch (TempConvertException e) {
                throw new RuntimeException(e);
            }
        }

        QuickSort.sort(doubles, comparator);

        List<String> sortedStrings = new ArrayList<>();
        for (Double doubleValue : doubles) {
            sortedStrings.add(String.valueOf(doubleValue));
        }

        return sortedStrings;
    }
}
