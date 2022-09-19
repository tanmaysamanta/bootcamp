package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.ColorCapacityReachedException;
import com.tw.step8.assignment5.exception.SpaceNotAvailableException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public void put(MagicBall otherMagicBall) throws SpaceNotAvailableException, ColorCapacityReachedException {
        checkExceptions(otherMagicBall);

        this.magicBalls.add(otherMagicBall);
    }

    private void checkExceptions(MagicBall otherMagicBall) throws SpaceNotAvailableException, ColorCapacityReachedException {
        if (this.magicBalls.size() >= this.capacity){
            throw new SpaceNotAvailableException(this.capacity);
        }

        long count = this.magicBalls.stream()
                .filter((magicBall) -> magicBall.isSameColor(otherMagicBall))
                .count();

        if (count >= otherMagicBall.getLimit()){
            throw  new ColorCapacityReachedException(otherMagicBall);
        }
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
