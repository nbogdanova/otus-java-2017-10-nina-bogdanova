package ru.otus.l051.example;

import ru.otus.l051.framework.annotations.After;
import ru.otus.l051.framework.annotations.Before;
import ru.otus.l051.framework.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static ru.otus.l051.framework.assertions.Assert.assertEquals;

public class ArraysTest {

    @Before
    public void before() {
        System.out.println("Some actions before test.");
    }

    @After
    public void after() {
        System.out.println("Some actions after test.");
    }

    @Test
    public void getList() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertEquals(3, list.size());
    }

}