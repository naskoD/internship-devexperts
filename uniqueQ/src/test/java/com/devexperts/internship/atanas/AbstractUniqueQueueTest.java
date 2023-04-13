package com.devexperts.internship.atanas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractUniqueQueueTest {
    private UniqueQueue<String> uniqueQueue;

    protected abstract UniqueQueue<String> createStringUniqueQueue();
    @BeforeEach
    void setUp() {
        this.uniqueQueue = createStringUniqueQueue();
    }

    @AfterEach
    void tearDown() {
        this.uniqueQueue=null;
    }

    @Test
    void add() {
        assertTrue(this.uniqueQueue.add("abc"));
        assertFalse(this.uniqueQueue.add("abc"));

        assertTrue(this.uniqueQueue.add(null));
        assertFalse(this.uniqueQueue.add(null));
    }

    @Test
    void get() {
        assertThrows(NoSuchElementException.class,() ->this.uniqueQueue.get());

        this.uniqueQueue.add(null);
        assertNull(this.uniqueQueue.get());
        assertThrows(NoSuchElementException.class,() ->this.uniqueQueue.get());

        String abc = "abc";
        String def = "def";
        this.uniqueQueue.add(null);
        this.uniqueQueue.add(abc);
        this.uniqueQueue.add(def);

        assertNull(this.uniqueQueue.get());
        assertEquals(abc,this.uniqueQueue.get());
        assertEquals(def,this.uniqueQueue.get());

        assertThrows(NoSuchElementException.class,() ->this.uniqueQueue.get());
    }
}
