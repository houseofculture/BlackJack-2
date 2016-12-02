package com.company;

import java.util.LinkedList;
/**
 * Created by student2 on 14.11.16
 */
public abstract class Player
{
    public int wallet;
    public static GameResult state;
    private Intellect intellect;
    private Better better;
    LinkedList<Hand>  hands = new LinkedList<>();
    String name;
    public boolean isSplitted;
    public Player(Intellect intellect,Better better) {
        this.intellect = intellect;
        this.better = better;
        this.wallet = 500;
        hands.add(new Hand());
    }
    public int bet;
    public void setBet()
    {
        this.bet = better.bet(wallet);
        wallet-=bet;
    }
    public void take(Card current,Hand hand)
    {
        hand.add(current);
    }
    public Command decision(Hand hand)
    {
        int score = hand.getScore();
        if(score>21)
        {
            return Command.STAND;
        }
        if(wallet-bet>=0 && hand.size() == 2 && intellect.dbl()) {
            wallet-=bet;
            bet*=2;
            return Command.DOUBLE;
        }
        return intellect.decide(score);
    }
    public void split()
    {
        for(Hand hand: hands)
        {
            if(hand.getFirst().value == hand.getLast().value && hand.size()==2)
            {
                hands.add(new Hand());
                hands.getLast().add(hand.pop());
                break;
            }
        }
    }
    public void clearHands()
    {
        hands.clear();
        hands.add(new Hand());
    }
}
