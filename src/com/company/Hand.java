package com.company;

import java.util.LinkedList;

/**
 * Created by student2 on 14.11.16.
 */
public class Hand extends LinkedList<Card>
{
    public int getScore()
    {
        int score = 0;
        for (Card card: this)
            score += card.getScore();

        if (this.hasAce() && score + 10 <= 21)
            score += 10;

        return score;
    }

    private boolean hasAce()
    {
        for (Card c: this)
            if (c.value == Value.ACE)
                return true;

        return false;
    }
}
