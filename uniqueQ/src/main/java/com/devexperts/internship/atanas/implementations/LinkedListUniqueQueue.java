package com.devexperts.internship.atanas.implementations;

import com.devexperts.internship.atanas.UniqueQueue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListUniqueQueue<T> implements UniqueQueue<T> {

    private final LinkedList<T> queue;

    public LinkedListUniqueQueue(){
        queue=new LinkedList<>();
    }

    @Override
    public boolean add(T obj) {
        if(queue.contains(obj)){
            return false;
        }
        return queue.offer(obj);
    }

    @Override
    public T get() throws NoSuchElementException {
        if(queue.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.queue.pollFirst();
    }
}
