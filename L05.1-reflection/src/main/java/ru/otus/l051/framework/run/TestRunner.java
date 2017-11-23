package ru.otus.l051.framework.run;

import com.google.common.reflect.ClassPath;
import ru.otus.l051.framework.run.entities.Status;
import ru.otus.l051.framework.run.entities.TestResult;
import ru.otus.l051.framework.annotations.After;
import ru.otus.l051.framework.annotations.Before;
import ru.otus.l051.framework.annotations.Test;
import ru.otus.l051.framework.assertions.AssertionException;
import ru.otus.l051.framework.run.entities.ReflectedTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for runing tests
 */
public class TestRunner {

    private TestRunner() {
    }

    /**
     * Run test methods from class
     * @param name name of test class
     * @return result of runing test methods
     */
    public static List<TestResult> runFromClass(String name) {
        try {
            Class klass = Class.forName(name);
            ReflectedTest test = analyse(klass);
            return run(test);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Run test methods from classes in package
     * @param name name of test package
     * @return result of runing test methods
     */
    public static List<TestResult> runFromPackage(String name) {
        List<TestResult> testResults = new ArrayList<>();
        try {
            ClassPath classpath = ClassPath.from(Thread.currentThread().getContextClassLoader());
            for(ClassPath.ClassInfo classInfo : classpath.getTopLevelClassesRecursive(name)) {
                Class klass = Class.forName(classInfo.getName());
                ReflectedTest test = analyse(klass);
                testResults.addAll(run(test));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return testResults;
    }

    private static ReflectedTest analyse(Class klass) {
        ReflectedTest reflectedTest = new ReflectedTest();
        reflectedTest.setName(klass.getName());
        try {
            reflectedTest.setConstructor(klass.getConstructor(null));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Test class " + klass.getName() + " does not contain constructor without parameters");
        }
        int beforeCount = 0, testCount = 0, afterCount = 0;
        for(Method method : klass.getMethods()) {
            boolean before = false, test = false, after = false;
            for(Annotation annotation : method.getDeclaredAnnotations()) {
                if(annotation.annotationType() == Before.class) {
                    before = true;
                    beforeCount++;
                }
                if(annotation.annotationType() == Test.class) {
                    test = true;
                    testCount++;
                }
                if(annotation.annotationType() == After.class) {
                    after = true;
                    afterCount++;
                }
            }
            if(before && !test && !after) {
                reflectedTest.setBefore(method);
            } else if(!before && test && !after) {
                reflectedTest.addTest(method);
            } else if(!before && !test && after) {
                reflectedTest.setAfter(method);
            } else if(before || test || after) {
                throw new RuntimeException("Test class " + klass.getName() + " contain several test annotations for method " + method.getName());
            }
        }
        if(testCount == 0) {
            throw new RuntimeException("Test class " + klass.getName() + " does not contain any test methods");
        }
        if(beforeCount > 1) {
            throw new RuntimeException("Test class " + klass.getName() + " contain several before methods");
        }
        if(afterCount > 1) {
            throw new RuntimeException("Test class " + klass.getName() + " contain several after methods");
        }
        return reflectedTest;
    }

    private static List<TestResult> run(ReflectedTest reflectedTest) {
        List<TestResult> results = new ArrayList<>();
        Constructor constructor = reflectedTest.getConstructor();
        Method before = reflectedTest.getBefore();
        Method after = reflectedTest.getAfter();
        for(Method test : reflectedTest.getTests()) {
            TestResult result = new TestResult();
            result.setName(reflectedTest.getName() + ":" + test.getName());
            Object object = null;
            try {
                object = constructor.newInstance();
                if(before != null) {
                    before.invoke(object);
                }
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
            try {
                test.invoke(object);
                result.setStatus(Status.SUCCESS);
            } catch (InvocationTargetException e) {
                Throwable target = e.getTargetException();
                if(target.getClass() == AssertionException.class) {
                    result.setStatus(Status.ASSERTION_FAILING);
                } else {
                    result.setStatus(Status.ERROR);
                }
                result.setMessage(target.getMessage());
            } catch(Exception e) {
                result.setStatus(Status.ERROR);
                result.setMessage(e.getMessage());
            }
            try {
                if(after != null) {
                    after.invoke(object);
                }
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
            results.add(result);
        }
        return results;
    }

}
