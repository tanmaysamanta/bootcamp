package com.tw.step8.assignment5.exception;

public class SpaceNotAvailableException extends Throwable {
    private final int capacity;

    public SpaceNotAvailableException(int capacity) {
        super();
        this.capacity = capacity;
    }

    @Override
    public String getMessage() {
        return "Maximum Capacity Reached : Limit is " + this.capacity;
    }
}
