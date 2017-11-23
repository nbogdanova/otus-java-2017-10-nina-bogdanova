package ru.otus.l051.example;

import ru.otus.l051.framework.annotations.After;
import ru.otus.l051.framework.annotations.Before;
import ru.otus.l051.framework.annotations.Test;

import java.util.Collections;
import java.util.List;

import static ru.otus.l051.framework.assertions.Assert.assertEquals;

public class CollectionsTest {

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
        List list = Collections.EMPTY_LIST;
        assertEquals(1, list.size());
    }

}