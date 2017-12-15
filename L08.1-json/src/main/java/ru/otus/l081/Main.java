package ru.otus.l081;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) {
        Gson gson = new Gson();
        String jsonString;

        int[] array = {1, 2, 3};
        Class klass = array.getClass();

        System.out.println("Before serialization: " + array.getClass().toString());
        jsonString = gson.toJson(array);
        System.out.println("Array of primitives: " + jsonString);
        array = gson.fromJson(jsonString, int[].class);
        System.out.println("After serialization: " + array.getClass().toString());

        System.out.println();

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("Before serialization: " + arrayList.getClass().toString());
        jsonString = gson.toJson(arrayList);
        System.out.println("ArrayList of primitives: " + jsonString);
        arrayList = gson.fromJson(jsonString, ArrayList.class);
        System.out.println("After serialization: " + arrayList.getClass().toString());

    }

}