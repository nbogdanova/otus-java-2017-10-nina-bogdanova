package ru.otus.l0111;

import org.apache.commons.collections4.CollectionUtils;

public class Main {

    public static void main(String... args) {
        Object[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Original array:");
        for(Object i : array) {
            System.out.println(i);
        }
        CollectionUtils.reverseArray(array);
        System.out.println("Reversible array:");
        for(Object i : array) {
            System.out.println(i);
        }
    }

}
