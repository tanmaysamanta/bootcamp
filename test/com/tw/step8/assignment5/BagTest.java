package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.SpaceNotAvailableException;
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
    void shouldPutAMagicBallToBag() throws SpaceNotAvailableException {
        Bag bag = new Bag();
        MagicBall magicBall = new MagicBall(Color.GREEN);

        bag.put(magicBall);

        assertTrue(bag.contains(magicBall));
    }

    @Test
    void shouldThrowExceptionForUnAvailableSpace() throws SpaceNotAvailableException {
        Bag bag = new Bag(1);
        MagicBall firstMagicBall = new MagicBall(Color.GREEN);
        MagicBall secondMagicBall = new MagicBall(Color.GREEN);

        bag.put(firstMagicBall);

        assertThrows(SpaceNotAvailableException.class, () -> bag.put(secondMagicBall));
    }
//
//    @Test
//    void shouldThrowExceptionIfWePutFourthGreenBall() throws SpaceNotAvailableException {
//        Bag bag = new Bag(1);
//        MagicBall greenMagicBall = new MagicBall(Color.GREEN);
//
//        bag.put(greenMagicBall);
//        bag.put(greenMagicBall);
//        bag.put(greenMagicBall);
//
//        assertThrows(SpaceNotAvailableException.class, () -> bag.put(greenMagicBall));
//    }
}