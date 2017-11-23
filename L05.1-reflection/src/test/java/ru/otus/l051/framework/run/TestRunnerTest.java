package ru.otus.l051.framework.run;

import org.junit.Test;
import ru.otus.l051.framework.run.entities.TestResult;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static ru.otus.l051.framework.run.entities.Status.ASSERTION_FAILING;
import static ru.otus.l051.framework.run.entities.Status.SUCCESS;

public class TestRunnerTest {

    @Test
    public void runFromClassWithValidTests() {
        List<TestResult> result = TestRunner.runFromClass("ru.otus.l051.example.ArraysTest");
        assertEquals(1, result.size());
        assertEquals(SUCCESS, result.get(0).getStatus());
    }

    @Test
    public void runFromClassWithInvalidTests() {
        List<TestResult> result = TestRunner.runFromClass("ru.otus.l051.example.CollectionsTest");
        assertEquals(1, result.size());
        assertEquals(ASSERTION_FAILING, result.get(0).getStatus());
        assertNotNull(result.get(0).getMessage());
    }

    @Test
    public void runFromPackage() {
        List<TestResult> result = TestRunner.runFromPackage("ru.otus.l051.example");
        assertEquals(2, result.size());
    }

}
