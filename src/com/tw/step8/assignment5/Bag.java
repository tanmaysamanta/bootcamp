package com.tw.step8.assignment5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bag {
    private final List<MagicBall> magicBalls;

    public Bag() {
        this.magicBalls = new ArrayList<MagicBall>(12);
    }

    public void put(MagicBall magicBall) {
        this.magicBalls.add(magicBall);
    }

    public boolean contains(MagicBall magicBall){
        return this.magicBalls.contains(magicBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bag bag = (Bag) o;

        return Objects.equals(magicBalls, bag.magicBalls);
    }

    @Override
    public int hashCode() {
        return magicBalls != null ? magicBalls.hashCode() : 0;
    }
}
