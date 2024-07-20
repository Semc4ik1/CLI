package ru.gumenuk.convert;

import ru.gumenuk.exception.TempConvertException;

public class ConvertInteger implements ConvertType<String, Integer> {
    @Override
    public Integer convert(String temp) throws TempConvertException {
        try {
            return Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            throw new TempConvertException("Неверный формат числа: " + e.getMessage());
        }
    }
}