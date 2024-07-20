package ru.gumenuk.convert;

import ru.gumenuk.exception.TempConvertException;

public class ConvertString implements ConvertType<String, String> {
    @Override
    public String convert(String temp) throws TempConvertException {
        return temp;
    }

}
