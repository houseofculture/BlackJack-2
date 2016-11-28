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

    public Command decision()
    {
        int score = hand.getScore();
        if(score>21)
        {
            return Command.STAND;
        }
        return intellect.decide(score);
    }
    public void split()
    {
        Hand hand2 = new Hand();
        for(int i =0;i<(int)(hand.size()/2);i++)
        {
            hand2.add(hand.getFirst());
            hand.remove(0);
        }
        isSplitted = true;
    }
}
