package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.*;

import java.util.*;

public class Bag {
    public static final int MAX_CAPACITY = 12;
    private final Map<Color, HashSet<MagicBall>> magicBalls;
    private final int capacity;

    public Bag() {
        this.capacity = MAX_CAPACITY;
        this.magicBalls = new HashMap<Color, HashSet<MagicBall>>() {
        };
    }

    Bag(int capacity) {
        this.capacity = capacity;
        this.magicBalls = new HashMap<>();
    }

    public void put(MagicBall otherMagicBall) throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException, CantPutBothBlackAndBlueException {
        Color color = otherMagicBall.getColor();
        HashSet<MagicBall> magicBalls = this.magicBalls.computeIfAbsent(color, k -> new HashSet<>());

        checkExceptions(otherMagicBall);
        magicBalls.add(otherMagicBall);
    }

    private void checkExceptions(MagicBall otherMagicBall) throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException, CantPutBothBlackAndBlueException {
        if (this.getSize() >= this.capacity) {
            throw new SpaceNotAvailableException(this.capacity);
        }

        Color color = otherMagicBall.getColor();
        HashSet<MagicBall> magicBalls = this.magicBalls.get(color);

        this.blackAndBlueException(color);
        this.yellowBallException(color);
        this.redBallException(color, magicBalls);
        this.greenBallException(otherMagicBall, magicBalls);
    }

    private void blackAndBlueException(Color color) throws CantPutBothBlackAndBlueException {
        if (color == Color.BLACK) {
            checkBlackOrBlueBallException(Color.BLUE);
            return;
        }
        if (color == Color.BLUE) {
            checkBlackOrBlueBallException(Color.BLACK);
        }
    }

    private void checkBlackOrBlueBallException(Color color) throws CantPutBothBlackAndBlueException {
        HashSet<MagicBall> blueBalls = this.magicBalls.computeIfAbsent(color, k -> new HashSet<>());
        if (blueBalls.size() > 0) {
            throw new CantPutBothBlackAndBlueException();
        }
    }

    private void greenBallException(MagicBall otherMagicBall, HashSet<MagicBall> magicBalls) throws ColorCapacityReachedException {
        boolean condition = magicBalls.size() >= otherMagicBall.getLimit();
        if (condition) {
            throw new ColorCapacityReachedException(otherMagicBall);
        }
    }

    private void redBallException(Color color, HashSet<MagicBall> magicBalls) throws CantPutRedException {
        HashSet<MagicBall> greenBalls = this.magicBalls.computeIfAbsent(Color.GREEN, k -> new HashSet<>());
        boolean condition = color == Color.RED && magicBalls.size() + 1 > greenBalls.size() * 2;
        if (condition) {
            throw new CantPutRedException(greenBalls.size());
        }
    }

    private void yellowBallException(Color color) throws YellowExceededFortyPercentCapacityException {
        HashSet<MagicBall> yellowBalls = this.magicBalls.computeIfAbsent(Color.YELLOW, k -> new HashSet<>());
        boolean condition = color == Color.YELLOW && yellowBalls.size() + 1 > 0.4 * this.getSize();
        if (condition) {
            throw new YellowExceededFortyPercentCapacityException(this.getSize());
        }
    }

    public int getSize() {
        return this.magicBalls.values()
                .stream()
                .map(HashSet::size)
                .mapToInt((value) -> Integer.parseInt(String.valueOf(value)))
                .sum();
    }

    public boolean contains(MagicBall magicBall) {
        Color color = magicBall.getColor();
        HashSet<MagicBall> magicBalls = this.magicBalls.get(color);
        return magicBalls.contains(magicBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bag bag = (Bag) o;

        if (capacity != bag.capacity) return false;
        return magicBalls.equals(bag.magicBalls);
    }

    @Override
    public int hashCode() {
        int result = magicBalls.hashCode();
        result = 31 * result + capacity;
        return result;
    }
}
