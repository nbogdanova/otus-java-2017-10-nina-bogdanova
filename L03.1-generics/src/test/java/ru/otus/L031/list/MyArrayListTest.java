package ru.otus.L031.list;

import org.junit.Test;
import ru.otus.l031.list.MyArrayList;

import java.util.Collections;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyArrayListTest {

    @Test
    public void add() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i=0; i<11; i++) {
            list.add(i);
        }
        assertEquals(11, list.size());
        for(int i=1; i<list.size(); i++) {
            assertTrue(list.get(i-1) < list.get(i));
        }
    }

    @Test
    public void addAll() {
        MyArrayList<Integer> list = new MyArrayList<>();
        Collections.addAll(list, 1, 2, 3);
        assertEquals(3, list.size());
        assertEquals(1, list.get(0).intValue());
        assertEquals(2, list.get(1).intValue());
        assertEquals(3, list.get(2).intValue());
    }

    @Test
    public void copy() {
        MyArrayList<Integer> dest = new MyArrayList<>();
        dest.add(0);
        dest.add(0);
        dest.add(0);
        MyArrayList<Integer> src = new MyArrayList<>();
        src.add(1);
        src.add(2);
        src.add(3);
        Collections.copy(dest, src);
        assertEquals(1, dest.get(0).intValue());
        assertEquals(2, dest.get(1).intValue());
        assertEquals(3, dest.get(2).intValue());
    }

    @Test
    public void sortIntegers() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        Collections.sort(list);
        for(int i=1; i<list.size(); i++) {
            assertTrue(list.get(i-1) < list.get(i));
        }
    }

    @Test
    public void sortPersons() {
        MyArrayList<Person> list = new MyArrayList<>();
        list.add(new Person("Pushkin"));
        list.add(new Person("Lermontov"));
        list.add(new Person("Tolstoy"));
        list.add(new Person("Block"));
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for(int i=1; i<list.size(); i++) {
            assertTrue(list.get(i).getName().compareTo(list.get(i-1).getName()) > 0);
        }
    }

    private class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}