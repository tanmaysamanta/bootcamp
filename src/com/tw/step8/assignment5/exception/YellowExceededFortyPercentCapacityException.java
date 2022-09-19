package com.tw.step8.assignment5.exception;

public class YellowExceededFortyPercentCapacityException extends Throwable {
    private int size;

    public YellowExceededFortyPercentCapacityException(int size) {
        super();
        this.size = size;
    }

    @Override
    public String getMessage() {
        return "Yellow ball can't take more than 40% capacity , Current capacity is :" + this.size;
    }
}
