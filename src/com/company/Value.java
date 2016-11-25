package com.company;


public enum Value
{
    ACE(1),
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10), QUEEN(10), KING(10);

    Value(int score)
    {
        this.score = score;
    }

    private int score;

    public int getScore() {
        return this.score;
    }
}
