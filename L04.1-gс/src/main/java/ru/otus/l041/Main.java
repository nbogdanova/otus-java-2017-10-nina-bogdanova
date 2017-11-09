package ru.otus.l041;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final int SIZE = 1 * 1000 * 1000;

    //не удается добиться запуска old generation gc
    public static void main(String... args) {
        long start = System.nanoTime();
        try {
            List<String> list = new ArrayList<>();
            for(int i = 0; i < 5; i++) {
                list = createGarbage();
            }
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError");
        } finally {
            long time = (System.nanoTime() - start) / 1_000_000;
            printStatistics();
        }
    }

    private static List<String> createGarbage() {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < SIZE; i++) {
            list.add(new String(new char[0]));
//            if(i % 2 == 0) {
//                list.remove(0);
//            }
            if(i % 1000 == 0) {
                List<String> newList = new ArrayList<>();
                newList.addAll(list);
                list = newList;
            }
        }
        return list;
    }

    private static void printStatistics() {
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            System.out.println("GC name: " + gcBean.getName()
                    + "; collection count: " + gcBean.getCollectionCount()
                    + "; collection time: " + gcBean.getCollectionTime());
        }
    }

}