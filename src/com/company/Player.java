package com.company;

/**
 * Created by student2 on 14.11.16.
 */
public abstract class Player
{
    public int wallet;
    public static GameResult state;
    private Intellect intellect;
    Hand hand = new Hand();
    String name;
    public boolean isSplitted;
    public Player(Intellect intellect) {
        this.intellect = intellect;
    }
    public void take(Card current)
    {
        hand.add(current);
    }
    public void take2(Card current)
    {
        hand2.add(current);
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
    public Command decision2()
    {
        int score = hand2.getScore();
        if(score>21)
        {
            return Command.STAND;
        }
        return intellect.decide(score);
    }
    public Hand hand2 = new Hand();
    public void split()
    {
        hand2.add(this.hand.getFirst());
        this.hand.remove(0);
        isSplitted = true;
    }
}
