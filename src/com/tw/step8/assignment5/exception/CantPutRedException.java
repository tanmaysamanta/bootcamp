package com.tw.step8.assignment5.exception;

import com.tw.step8.assignment5.MagicBall;

public class CantPutRedException extends Throwable {

    private int size;

    public CantPutRedException(int size) {
        this.size = size;
    }

    @Override
    public String getMessage() {
        return "Can't put more than twice of green ball, Green ball count is : " + this.size;
    }
}
