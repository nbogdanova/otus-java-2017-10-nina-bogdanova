package ru.otus.l021;

/**
 * java -Xmx512m -Xms512m -jar L02.1-memory.jar
 */
public class Main {

    public static void main(String... args) {
        System.out.println("Experiment started");
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = 0, memoryAfter = 0, size = 0;

        System.gc();
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        String str = "";
        System.gc();
        memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        size = memoryAfter - memoryBefore;
        System.out.println("Parameters of string: length: " + str.length() + "; memory: " + size);

        System.gc();
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        String str1 = "a";
        System.gc();
        memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        size = memoryAfter - memoryBefore;
        System.out.println("Parameters of string: length: " + str1.length() + "; memory: " + size);

        System.gc();
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        String str2 = "bc";
        System.gc();
        memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        size = memoryAfter - memoryBefore;
        System.out.println("Parameters of string: length: " + str2.length() + "; memory: " + size);

        System.gc();
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        String str3 = "def";
        System.gc();
        memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        size = memoryAfter - memoryBefore;
        System.out.println("Parameters of string: length: " + str3.length() + "; memory: " + size);
    }

}
