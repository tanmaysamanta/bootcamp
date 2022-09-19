package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.CantPutRedException;
import com.tw.step8.assignment5.exception.ColorCapacityReachedException;
import com.tw.step8.assignment5.exception.SpaceNotAvailableException;
import com.tw.step8.assignment5.exception.YellowExceededFortyPercentCapacityException;
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
    void shouldPutAMagicBallToBag() throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException {
        Bag bag = new Bag();
        MagicBall magicBall = new MagicBall(Color.GREEN);

        bag.put(magicBall);

        assertTrue(bag.contains(magicBall));
    }

    @Test
    void shouldThrowExceptionForUnAvailableSpace() throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException {
        Bag bag = new Bag(1);
        MagicBall firstMagicBall = new MagicBall(Color.GREEN);
        MagicBall secondMagicBall = new MagicBall(Color.GREEN);

        bag.put(firstMagicBall);

        assertThrows(SpaceNotAvailableException.class, () -> bag.put(secondMagicBall));
    }

    @Test
    void shouldThrowExceptionIfWePutFourthGreenBall() throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException {
        Bag bag = new Bag(4);
        MagicBall greenMagicBall = new MagicBall(Color.GREEN);

        bag.put(greenMagicBall);
        bag.put(greenMagicBall);
        bag.put(greenMagicBall);

        assertThrows(ColorCapacityReachedException.class, () -> bag.put(greenMagicBall));
    }

    @Test
    void shouldThrowExceptionIfPuttingRedBallMoreThanDoubleOfGreenBall() {
        Bag bag = new Bag(1);
        MagicBall magicBall = new MagicBall(Color.RED);

        assertThrows(CantPutRedException.class, () -> bag.put(magicBall));
    }

    @Test
    void shouldThrowExceptionForPuttingYellowBallIfItExceedsFortyPercentCapacity() throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException {
        Bag bag = new Bag(3);
        MagicBall yellowBall = new MagicBall(Color.YELLOW);
        MagicBall redBall = new MagicBall(Color.GREEN);

        bag.put(redBall);

        assertThrows(YellowExceededFortyPercentCapacityException.class, () -> bag.put(yellowBall));
    }
}