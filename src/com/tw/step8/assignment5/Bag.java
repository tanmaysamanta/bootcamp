package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.SpaceNotAvailableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bag {
    public static final int MAX_CAPACITY = 12;
    private final List<MagicBall> magicBalls;
    private final int capacity;

    public Bag() {
        this.capacity = MAX_CAPACITY;
        this.magicBalls = new ArrayList<MagicBall>(this.capacity);
    }

    Bag(int capacity){
        this.capacity = capacity;
        this.magicBalls = new ArrayList<MagicBall>(this.capacity);
    }

    public void put(MagicBall magicBall) throws SpaceNotAvailableException {
        if (this.magicBalls.size() >= this.capacity){
            throw new SpaceNotAvailableException(this.capacity);
        }
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
