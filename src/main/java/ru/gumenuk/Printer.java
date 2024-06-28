package ru.gumenuk;

import java.io.IOException;
import java.util.List;

public interface Printer {
    void println(String content, List<String> lines) throws IOException;

    void error(String error);
}