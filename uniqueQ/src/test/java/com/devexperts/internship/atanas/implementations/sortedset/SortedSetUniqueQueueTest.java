package com.devexperts.internship.atanas.implementations.sortedset;

import com.devexperts.internship.atanas.AbstractUniqueQueueTest;
import com.devexperts.internship.atanas.UniqueQueue;

public class SortedSetUniqueQueueTest extends AbstractUniqueQueueTest {
    @Override
    protected UniqueQueue<String> createStringUniqueQueue() {
        return new SortedSetUniqueQueue<>();
    }
}
