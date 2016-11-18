package com.company;

public class Card
{
    Suit suit;
    Values value;

    @Override
    public String toString()
    {

        return ""+value+ " of "+ suit;
    }

    public Card(Suit suit, Values value)
    {
        this.suit = suit;
        this.value = value;
    }
}
