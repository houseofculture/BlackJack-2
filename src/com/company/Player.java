package com.company;

/**
 * Created by student2 on 14.11.16.
 */
public abstract class Player
{
    private Intellect intellect;

    Hand hand = new Hand();

    public Player(Intellect intellect) {
        this.intellect = intellect;
    }

    public void take(Card current)
    {
        hand.add(current);
    }

    public Command decision()
    {
        return intellect.decide(hand.getScore());
    }

}
