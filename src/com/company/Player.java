package com.company;

/**
 * Created by student2 on 14.11.16.
 */
public abstract class Player
{
    private int startMoney = 50;
    public int wallet;
    public static GameResult state;
    private Intellect intellect;
    Hand hand = new Hand();
    String name;

    public Player(Intellect intellect) {
        this.intellect = intellect;
        wallet = startMoney;
    }
    public void take(Card current)
    {
        hand.add(current);
    }

    public Command decision()
    {
        int score = hand.getScore();
        if(score>21)
        {
            return Command.STAND;
        }
        return intellect.decide(score);
    }

}
