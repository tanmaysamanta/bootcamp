package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicBallTest {

    @Test
    void shouldTellWhetherTheColorIsSameOrNot() {
        MagicBall firstGreenBall = new MagicBall(Color.GREEN);
        MagicBall secondGreenBall = new MagicBall(Color.GREEN);

        assertTrue(firstGreenBall.isSameColor(secondGreenBall));
    }

    @Test
    void getColor() {
    }

    @Test
    void getLimit() {
    }
}