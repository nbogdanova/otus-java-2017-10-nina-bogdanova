package ru.otus.l031;

import ru.otus.l031.list.MyArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final int MEASURE_COUNT = 10;

    public static void main(String... args) {
        List<Integer> arrayList = null;
        List<Integer> myArrayList = null;
        long fillArrayListTime = 0;
        long fillMyArrayListTime = 0;
        long sortArrayListTime = 0;
        long sortMyArrayListTime = 0;

        for(int i = 0; i < MEASURE_COUNT; i++) {
            arrayList = new ArrayList<>();
            List<Integer> finalArrayList = arrayList;
            fillArrayListTime += calcTime(() -> fillList(finalArrayList));
            sortArrayListTime += calcTime(() -> Collections.sort(finalArrayList));

            myArrayList = new MyArrayList<>();
            List<Integer> finalMyArrayList = myArrayList;
            fillMyArrayListTime += calcTime(() -> fillList(finalMyArrayList));
            sortMyArrayListTime += calcTime(() -> Collections.sort(finalMyArrayList));
        }

        fillArrayListTime = fillArrayListTime / MEASURE_COUNT;
        fillMyArrayListTime = fillMyArrayListTime / MEASURE_COUNT;
        sortArrayListTime = sortArrayListTime / MEASURE_COUNT;
        sortMyArrayListTime = sortMyArrayListTime / MEASURE_COUNT;

        System.out.println("Time of operations:");
        System.out.println("Filing ArrayList: " + fillArrayListTime + "ns (" + fillArrayListTime / 1_000_000 + "ms)");
        System.out.println("Filing MyArrayList: " + fillMyArrayListTime + "ns (" + fillMyArrayListTime / 1_000_000 + "ms)");
        System.out.println("Sorting ArrayList: " + sortArrayListTime + "ns (" + sortArrayListTime / 1_000_000 + "ms)");
        System.out.println("Sorting MyArrayList: " + sortMyArrayListTime + "ns (" + sortMyArrayListTime / 1_000_000 + "ms)");

    }

    private static void fillList(List<Integer> list) {
        int min = 0;
        int max = 9_999;
        for (int i = max; i > min - 1; i--) {
            list.add(i);
        }
    }

    private static long calcTime(Runnable runnable) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long startTime = System.nanoTime();
        runnable.run();
        long finishTime = System.nanoTime();
        return (finishTime - startTime);
    }

}
