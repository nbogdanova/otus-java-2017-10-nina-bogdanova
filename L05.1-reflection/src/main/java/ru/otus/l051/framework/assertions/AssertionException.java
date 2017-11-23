package ru.otus.l051.framework.assertions;

import java.text.MessageFormat;

public class AssertionException extends RuntimeException {

    private static final String MESSAGE = "Assertion failed: expected {0}, actual {1}.";

    public AssertionException(int expected, int actual) {
        super(MessageFormat.format(MESSAGE, expected, actual));
    }

}
