package com.tw.step8.assignment5;

public enum Color {
    GREEN(3), RED(6), YELLOW(5), BLACK(12), BLUE(12);

    final int limit;

    Color(int limit) {
        this.limit = limit;
    }
}
