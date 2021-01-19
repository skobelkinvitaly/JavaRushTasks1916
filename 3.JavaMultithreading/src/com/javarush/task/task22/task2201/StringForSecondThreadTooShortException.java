package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException(Exception e) {
    }

    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("string index out of range: -1");
    }
}
