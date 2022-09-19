package com.tw.step8.assignment5;

public class MagicBall {
    private final Color color;

    public MagicBall(Color color) {
        this.color = color;
    }

    public boolean isSameColor(MagicBall otherMagicBall) {
        return this.color == otherMagicBall.color;
    }

    public Color getColor(){
        return this.color;
    }

    public int getLimit() {
        return this.color.limit;
    }
}
