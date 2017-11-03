package ru.otus.l031.list;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private static final int EMPTY_LIST_SIZE = 0;

    private static final int MAX_LIST_SIZE = Integer.MAX_VALUE - 8;

    private static final int BATCH_SIZE = 10;

    private static final Object[] EMPTY_DATA = new Object[EMPTY_LIST_SIZE];

    private int size;

    private int realSize;

    private Object[] data;

    public MyArrayList() {
        size = EMPTY_LIST_SIZE;
        realSize = EMPTY_LIST_SIZE;
        data = EMPTY_DATA;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > EMPTY_LIST_SIZE ? false : true;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for(int i=0; i<size; i++) {
            array[i] = data[i];
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        if(size == realSize) {
            if(size + BATCH_SIZE > MAX_LIST_SIZE) {
                throw new RuntimeException("It is not possible to increase the size of the list");
            }
            realSize = size + BATCH_SIZE;
            Object[] resizedData = new Object[realSize];
            for(int i=0; i<size; i++) {
                resizedData[i] = data[i];
            }
            data = resizedData;
        }
        data[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
}

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        if(index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E)data[index];
    }

    @Override
    public E set(int index, E element) {
        if(index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Object oldElement = data[index];
        data[index] = element;
        return (E)oldElement;
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private class MyListIterator implements ListIterator<E> {

        private int index = -1;

        @Override
        public boolean hasNext() {
            return index < size-1 ? true : false;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E)data[++index];
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            if(index >= 0 || index < size) {
                data[index] = e;
            } else {
                throw new IllegalStateException();
            }
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }

}