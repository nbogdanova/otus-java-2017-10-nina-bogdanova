package ru.otus.l051.framework.run.entities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectedTest {

    private String name;

    private Constructor constructor;

    private Method before;

    private Method after;

    private List<Method> tests;

    public ReflectedTest() {
        tests = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public Method getBefore() {
        return before;
    }

    public void setBefore(Method before) {
        this.before = before;
    }

    public Method getAfter() {
        return after;
    }

    public void setAfter(Method after) {
        this.after = after;
    }

    public List<Method> getTests() {
        return tests;
    }

    public void setTests(List<Method> tests) {
        this.tests = tests;
    }

    public void addTest(Method test) {
        tests.add(test);
    }

}
