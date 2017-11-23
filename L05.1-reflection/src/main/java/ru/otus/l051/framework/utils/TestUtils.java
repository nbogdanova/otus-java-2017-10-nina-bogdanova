package ru.otus.l051.framework.utils;

import ru.otus.l051.framework.run.entities.TestResult;

import java.text.MessageFormat;
import java.util.List;

/**
 * Class with utility methods for testing
 */
public class TestUtils {

    private static final String MESSAGE = "{0}; {1}; {2}";

    private TestUtils() {
    }

    /**
     * Print testing results
     * @param results List of test results
     */
    public static void print(List<TestResult> results) {
        for(TestResult result : results) {
            System.out.println(MessageFormat.format(MESSAGE, result.getName(), result.getStatus(), result.getMessage()));
        }
    }

}
