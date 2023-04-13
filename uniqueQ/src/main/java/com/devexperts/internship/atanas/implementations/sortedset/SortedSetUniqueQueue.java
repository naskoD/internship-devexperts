package com.devexperts.internship.atanas.implementations.sortedset;

import com.devexperts.internship.atanas.UniqueQueue;

import java.util.NoSuchElementException;
import java.util.TreeSet;

public class SortedSetUniqueQueue<T> implements UniqueQueue<T> {

    private final TreeSet<DateTimeOfInitializationWrapper<T>> set;

    public SortedSetUniqueQueue(){
        this.set = new TreeSet<>();
    }


    @Override
    public boolean add(T obj) {
        DateTimeOfInitializationWrapper<T> newQueueElement = new DateTimeOfInitializationWrapper<>(obj);
        return this.set.add(newQueueElement);
    }

    @Override
    public T get() throws NoSuchElementException {
        DateTimeOfInitializationWrapper<T> firstWrapper = this.set.pollFirst();
        if(firstWrapper==null){
            throw new NoSuchElementException();
        }
        return firstWrapper.getWrappedObj();
    }
}