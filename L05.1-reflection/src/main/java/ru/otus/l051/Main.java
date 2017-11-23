package ru.otus.l051;

import ru.otus.l051.framework.run.TestRunner;
import ru.otus.l051.framework.run.entities.TestResult;
import ru.otus.l051.framework.utils.TestUtils;

import java.util.List;

public class Main {

    public static void main(String... args) {
        List<TestResult> results = TestRunner.runFromPackage("ru.otus.l051.example");
        TestUtils.print(results);
    }

}