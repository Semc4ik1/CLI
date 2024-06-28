package ru.gumenuk;

import java.io.IOException;
import java.util.List;

public interface Reader {
     List<String> read(String container) throws IOException;

}
