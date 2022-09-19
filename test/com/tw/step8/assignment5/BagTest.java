package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    @Test
    void shouldCreateABagOfCapacityTwelve() {
        Bag firstBag = new Bag();
        Bag secondBag = new Bag();

        assertEquals(firstBag, secondBag);
    }

    @Test
    void shouldPutAMagicBallToBag() {
        Bag bag = new Bag();
        MagicBall magicBall = new MagicBall();

        bag.put(magicBall);

        assertTrue(bag.contains(magicBall));
    }
}