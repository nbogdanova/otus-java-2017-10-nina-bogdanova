package ru.otus.l051.framework.assertions;

import ru.otus.l051.framework.assertions.AssertionException;

public class Assert {

    private Assert() {
    }

    public static void assertEquals(int expected, int actual) {
        if(expected != actual) {
            throw new AssertionException(expected, actual);
        }
    }

}