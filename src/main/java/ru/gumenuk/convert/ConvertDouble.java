package ru.gumenuk.convert;

import ru.gumenuk.exception.TempConvertException;

public class ConvertDouble implements ConvertType <String, Double> {
    @Override
    public Double convert(String temp) throws TempConvertException {
        try {
            return Double.parseDouble(temp);
        } catch (NumberFormatException e) {
            throw new TempConvertException("Неверный формат числа: " + e.getMessage());
        }
    }
}
