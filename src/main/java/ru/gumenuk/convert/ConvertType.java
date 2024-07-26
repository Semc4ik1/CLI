package ru.gumenuk.convert;

import ru.gumenuk.exception.TempConvertException;

public interface ConvertType<I extends Object, O extends Object> {
    O convert(I temp) throws TempConvertException;
}
