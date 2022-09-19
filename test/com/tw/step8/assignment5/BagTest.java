package com.tw.step8.assignment5;

import com.tw.step8.assignment5.exception.*;
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
    void shouldPutAMagicBallToBag() throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException, CantPutBothBlackAndBlueException {
        Bag bag = new Bag();
        MagicBall magicBall = new MagicBall(Color.GREEN);

        bag.put(magicBall);

        assertTrue(bag.contains(magicBall));
    }

    @Test
    void shouldThrowExceptionForUnAvailableSpace() throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException, CantPutBothBlackAndBlueException {
        Bag bag = new Bag(1);
        MagicBall firstMagicBall = new MagicBall(Color.GREEN);
        MagicBall secondMagicBall = new MagicBall(Color.GREEN);

        bag.put(firstMagicBall);

        assertThrows(SpaceNotAvailableException.class, () -> bag.put(secondMagicBall));
    }

    @Test
    void shouldThrowExceptionIfWePutFourthGreenBall() throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException, CantPutBothBlackAndBlueException {
        Bag bag = new Bag(4);
        MagicBall firstGreenBall = new MagicBall(Color.GREEN);
        MagicBall secondGreenBall = new MagicBall(Color.GREEN);
        MagicBall thirdGreenBall = new MagicBall(Color.GREEN);
        MagicBall fourthGreenBall = new MagicBall(Color.GREEN);

        bag.put(firstGreenBall);
        bag.put(secondGreenBall);
        bag.put(thirdGreenBall);

        assertThrows(ColorCapacityReachedException.class, () -> bag.put(fourthGreenBall));
    }

    @Test
    void shouldThrowExceptionIfPuttingRedBallMoreThanDoubleOfGreenBall() {
        Bag bag = new Bag(1);
        MagicBall magicBall = new MagicBall(Color.RED);

        assertThrows(CantPutRedException.class, () -> bag.put(magicBall));
    }

    @Test
    void shouldThrowExceptionForPuttingYellowBallIfItExceedsFortyPercentCapacity() throws SpaceNotAvailableException, ColorCapacityReachedException, CantPutRedException, YellowExceededFortyPercentCapacityException, CantPutBothBlackAndBlueException {
        Bag bag = new Bag(3);
        MagicBall yellowBall = new MagicBall(Color.YELLOW);
        MagicBall redBall = new MagicBall(Color.GREEN);

        bag.put(redBall);

        assertThrows(YellowExceededFortyPercentCapacityException.class, () -> bag.put(yellowBall));
    }

    @Test
    void shouldThrowExceptionIfPuttingBothBlackAndBlueInSameBag() throws SpaceNotAvailableException, ColorCapacityReachedException, YellowExceededFortyPercentCapacityException, CantPutRedException, CantPutBothBlackAndBlueException {
        Bag bag = new Bag(3);
        MagicBall blackBall = new MagicBall(Color.BLACK);
        MagicBall blueBall = new MagicBall(Color.BLUE);

        bag.put(blueBall);

        assertThrows(CantPutBothBlackAndBlueException.class, () -> bag.put(blackBall));
    }
}