package com.devexperts.internship.atanas.implementations;

import com.devexperts.internship.atanas.AbstractUniqueQueueTest;
import com.devexperts.internship.atanas.UniqueQueue;

public class LinkedListUniqueQueueTest extends AbstractUniqueQueueTest {
    @Override
    protected UniqueQueue<String> createStringUniqueQueue() {
        return new LinkedListUniqueQueue<>();
    }
}
