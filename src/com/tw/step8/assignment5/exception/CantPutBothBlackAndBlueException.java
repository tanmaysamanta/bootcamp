package com.tw.step8.assignment5.exception;

public class CantPutBothBlackAndBlueException extends Throwable {
    @Override
    public String getMessage() {
        return "Both black and blue can't be added in same bag";
    }
}
