package ru.gumenuk;

public class WrongKeyException extends RuntimeException {
    public WrongKeyException() {
        super();
    }

    public WrongKeyException(String message) {
        super(message);
    }
}
