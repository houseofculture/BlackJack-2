package com.company;

/**
 * Created by student2 on 14.11.16.
 */
public class Dealer extends Computer
{
    Deck deck = new Deck();

    public Dealer() {
        super(new DealerIntellect(),null);
    }

    public void deal(Player player,Hand hand) {
        Card current = deck.pop();
        player.take(current,hand);
    }
}
