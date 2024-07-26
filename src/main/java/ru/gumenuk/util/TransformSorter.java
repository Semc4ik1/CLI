package ru.gumenuk.util;

import ru.gumenuk.comparator.DoubleComparator;
import ru.gumenuk.comparator.IntegerComparator;
import ru.gumenuk.comparator.StringComparator;
import ru.gumenuk.convert.ConvertDouble;
import ru.gumenuk.convert.ConvertInteger;
import ru.gumenuk.exception.TempConvertException;
import ru.gumenuk.options.SortDataType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TransformSorter {
    public List<String> sort(SortDataType sortDataType, List<String> inputStrings) {
        switch (sortDataType) {
            case INTEGER:
                return sortIntegers(inputStrings, new IntegerComparator());
            case STRING:
                return sortString(inputStrings, new StringComparator());
            case DOUBLE:
                return sortDoubles(inputStrings, new DoubleComparator());

            default:
                throw new RuntimeException("Неподдерживаемый тип данных: " + sortDataType);
        }
    }

    private List<String> sortString(List<String> lines, StringComparator comparator) {
        QuickSort.sort(lines, comparator);
        return lines;
    }

    private List<String> sortIntegers(List<String> integersAsString, IntegerComparator comparator) {
        ConvertInteger convertInteger = new ConvertInteger();
        List<Integer> integers = new ArrayList<>();

        for (String s : integersAsString) {
            try {
                Integer integer = convertInteger.convert(String.valueOf(s));
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
