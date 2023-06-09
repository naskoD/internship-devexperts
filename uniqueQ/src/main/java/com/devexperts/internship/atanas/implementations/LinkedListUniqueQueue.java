package com.devexperts.internship.atanas.implementations;

import com.devexperts.internship.atanas.UniqueQueue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * An implementation of the UniqueQueue<T> interface. The <code>add</code> method has
 * time complexity of O(n). The <code>get</code> method - O(1).
 * @param <T>
 */
public class LinkedListUniqueQueue<T> implements UniqueQueue<T> {

    private final LinkedList<T> queue;

    public LinkedListUniqueQueue(){
        queue=new LinkedList<>();
    }

    @Override
    public synchronized boolean add(T obj) {
        if(queue.contains(obj)){
            return false;
        }
        return queue.offer(obj);
    }

    @Override
    public synchronized T get() throws NoSuchElementException {
        if(queue.isEmpty()){
            throw new NoSuchElementException();
        }
        return this.queue.pollFirst();
    }
}
