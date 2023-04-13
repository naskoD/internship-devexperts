package com.devexperts.internship.atanas;

import java.util.NoSuchElementException;

public interface UniqueQueue<T> {
    /**
     * Adds the provided object into the end of the queue,
     * if it isn't already available in it.
     *
     * @param obj object that will be added into the queue
     * @return true if the object was successfully added into the queue
     */
    boolean add(T obj);

    /**
     * Get the first element of the queue, if the latter isn't empty.
     * Otherwise, throw NoSuchElementException.
     *
     * @return the first element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
     T get() throws NoSuchElementException;
}
