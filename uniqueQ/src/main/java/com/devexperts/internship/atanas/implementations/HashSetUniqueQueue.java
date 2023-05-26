package com.devexperts.internship.atanas.implementations;

import com.devexperts.internship.atanas.UniqueQueue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * An implementation of the UniqueQueue<T> interface. The <code>add</code> method has
 * time complexity of O(1). The <code>get</code> method - O(1).
 * @param <T>
 */
public class HashSetUniqueQueue<T> implements UniqueQueue<T> {

    private final HashSet<T> hashSetContainer;
    private final LinkedList<T> queue;

    public HashSetUniqueQueue(){
        this.hashSetContainer = new HashSet<>();
        this.queue = new LinkedList<>();
    }

    @Override
    public synchronized boolean add(T obj) {
        if(hashSetContainer.add(obj)){
            return queue.offer(obj);
        }
        return false;
    }

    @Override
    public synchronized T get() throws NoSuchElementException {
        if(queue.isEmpty()){
            throw new NoSuchElementException();
        }
        T first = queue.pollFirst();
        hashSetContainer.remove(first);

        return first;
    }

}
