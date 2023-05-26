package com.devexperts.internship.atanas.implementations;

import com.devexperts.internship.atanas.AbstractUniqueQueueTest;
import com.devexperts.internship.atanas.UniqueQueue;

public class HashSetUniqueQueueTest extends AbstractUniqueQueueTest {
    @Override
    protected UniqueQueue<String> createStringUniqueQueue() {
        return new HashSetUniqueQueue<>();
    }
}