package com.tw.step8.assignment5.exception;

import com.tw.step8.assignment5.MagicBall;

public class ColorCapacityReachedException extends Throwable {
    private final MagicBall magicBall;

    public ColorCapacityReachedException(MagicBall magicBall) {
        this.magicBall = magicBall;
    }

    @Override
    public String getMessage() {
        return "Max capacity of given color is : " + magicBall.getColor();
    }
}
