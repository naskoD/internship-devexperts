package com.devexperts.internship.atanas.implementations.sortedset;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeOfInitializationWrapperTest {

    @Test
    void testEquals() {
        DateTimeOfInitializationWrapper<String> emptyStringWrapper = new DateTimeOfInitializationWrapper<>("");
        assertTrue(emptyStringWrapper.equals(emptyStringWrapper));

        assertFalse(emptyStringWrapper.equals(null));

        assertFalse(emptyStringWrapper.equals(""));

        assertTrue(emptyStringWrapper.equals(new DateTimeOfInitializationWrapper<>("")));
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class CompareToTests{
        private DateTimeOfInitializationWrapper<String> emptyStringWrapper;
        @BeforeAll
        void setUp() {
            emptyStringWrapper = new DateTimeOfInitializationWrapper<>("");
        }

        @AfterAll
        void tearDown() {
            emptyStringWrapper = null;
        }

        @Test
        void testCompareTo_sameObject() {
            assertEquals(0, emptyStringWrapper.compareTo(emptyStringWrapper));
        }

        @ParameterizedTest
        @NullSource
        void testCompareTo_NullArgument(DateTimeOfInitializationWrapper<String> obj) {
            Exception exception = assertThrows(IllegalArgumentException.class,() -> emptyStringWrapper.compareTo(obj));
            assertEquals(DateTimeOfInitializationWrapper.COMPARISON_ERROR_MESSAGE,exception.getMessage());
        }

        @Test
        void testCompareTo_sameWrappedObject() {
            assertEquals(0, emptyStringWrapper.compareTo(new DateTimeOfInitializationWrapper<>("")));
        }

        @Test
        void testCompareTo_LessAndGreaterThan() throws InterruptedException {
            Thread.sleep(10);
            DateTimeOfInitializationWrapper<String> otherStringWrapper = new DateTimeOfInitializationWrapper<>("other");

            assertEquals(-1, emptyStringWrapper.compareTo(otherStringWrapper));
            assertEquals(1, otherStringWrapper.compareTo(emptyStringWrapper));
        }

    }

    private static Stream<Object> testHashCode() {
        return Stream.of(null,new Object(),"", 0);
    }
    @ParameterizedTest
    @MethodSource
    void testHashCode(Object obj) {
        DateTimeOfInitializationWrapper<Object> testWrapper = new DateTimeOfInitializationWrapper<>(obj);
        assertEquals(Arrays.hashCode(new Object[]{obj}),testWrapper.hashCode());
    }
}