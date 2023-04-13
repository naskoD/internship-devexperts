package com.devexperts.internship.atanas.implementations.sortedset;

import java.time.Instant;
import java.util.Objects;

public class DateTimeOfInitializationWrapper<T> implements Comparable<DateTimeOfInitializationWrapper<T>>{
    public static final String COMPARISON_ERROR_MESSAGE = "Can't compare the object with null or an object from a different class!";
    private final Instant wrapperInitializedAt;
    private final T wrappedObj;

    public DateTimeOfInitializationWrapper(T wrappedObj){
        this.wrappedObj=wrappedObj;
        this.wrapperInitializedAt = Instant.now();
    }


    public T getWrappedObj() {
        return wrappedObj;
    }

    public Instant getWrapperInitializedAt() {
        return wrapperInitializedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTimeOfInitializationWrapper<?> that = (DateTimeOfInitializationWrapper<?>) o;
        return Objects.equals(wrappedObj, that.getWrappedObj());
    }

    @Override
    public int hashCode() {
        return Objects.hash(wrappedObj);
    }

    @Override
    public int compareTo(DateTimeOfInitializationWrapper<T> o) {
        if (this == o) return 0;
        if (o == null) {
            throw new IllegalArgumentException(COMPARISON_ERROR_MESSAGE);
        }

        if(Objects.equals(wrappedObj, o.getWrappedObj())){
            return 0;
        }
        else {
            return this.wrapperInitializedAt.isBefore(o.getWrapperInitializedAt())?-1:1;
        }
    }
}
