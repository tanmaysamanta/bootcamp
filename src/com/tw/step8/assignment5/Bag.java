package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.CantPutRedException;
import com.tw.step8.assignment5.exception.ColorCapacityReachedException;
import com.tw.step8.assignment5.exception.SpaceNotAvailableException;
import com.tw.step8.assignment5.exception.YellowExceededFortyPercentCapacityException;

import java.util.*;

public class Bag {
    public static final int MAX_CAPACITY = 12;
    private final Map<Color, ArrayList<MagicBall>> magicBalls;
    private final int capacity;

    public Bag() {
        this.capacity = MAX_CAPACITY;
        this.magicBalls = new HashMap<Color, ArrayList<MagicBall>>() {
        };
    }

    Bag(int capacity) {
        this.capacity = capacity;
        this.magicBalls = new HashMap<Color, ArrayList<MagicBall>>();
    }

    public void put(MagicBall otherMagicBall) throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException {
        Color color = otherMagicBall.getColor();
        ArrayList<MagicBall> magicBalls = this.magicBalls.computeIfAbsent(color, k -> new ArrayList<>());

        checkExceptions(otherMagicBall);
        magicBalls.add(otherMagicBall);
    }

    private void checkExceptions(MagicBall otherMagicBall) throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException {
        if (this.getSize() >= this.capacity) {
            throw new SpaceNotAvailableException(this.capacity);
        }

        Color color = otherMagicBall.getColor();
        ArrayList<MagicBall> magicBalls = this.magicBalls.get(color);
        ArrayList<MagicBall> greenBalls = this.magicBalls.computeIfAbsent(Color.GREEN, k -> new ArrayList<>());
        ArrayList<MagicBall> yellowBalls = this.magicBalls.computeIfAbsent(Color.YELLOW, k -> new ArrayList<>());

        if (color == Color.YELLOW && yellowBalls.size() + 1 > 0.4 * this.getSize()){
            throw new YellowExceededFortyPercentCapacityException(this.getSize());
        }

        if (color == Color.RED && magicBalls.size() + 1 > greenBalls.size() * 2) {
            throw new CantPutRedException(greenBalls.size());
        }

        if (magicBalls.size() >= otherMagicBall.getLimit()) {
            throw new ColorCapacityReachedException(otherMagicBall);
        }
    }

    public int getSize() {
        int count = this.magicBalls.values()
                .stream()
                .map((balls) -> balls.size())
                .mapToInt((value) -> Integer.parseInt(String.valueOf(value)))
                .sum();

        return count;
    }

    public boolean contains(MagicBall magicBall) {
        Color color = magicBall.getColor();
        ArrayList<MagicBall> magicBalls = this.magicBalls.get(color);
        return magicBalls.contains(magicBall);
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
