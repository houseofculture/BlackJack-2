package com.company;

import sun.security.util.Length;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by student2 on 28.11.16.
 */
public class Table {
    Dealer dealer;
    List<Player> players = new LinkedList<>();
    public Table()
    {
        dealer = new Dealer();
        players.add(new Computer(new LimitIntellect(17),new HalfBetter()));
        players.add(new Computer(new LimitIntellect(20),new HalfBetter()));
        players.add(new Human(new ConsoleIntellect(),new ConsoleBetter()));
        players.add(dealer);
    }
    public void makeBets()
    {
        for(Player player: players)
        {
            if (player!=dealer) {
                player.setBet();
                System.out.println(player.name + " : " + player.bet);
            }
        }
    }

    public void deal()
    {
        for (Player player : players) {
            dealer.deal(player,player.hands.getFirst());
            dealer.deal(player,player.hands.getFirst());
            System.out.println(player.name +" : "+ player.hands.getFirst());
            player.split();
        }
    }
    public void game()
    {
        for (Player player : players) {
                for(Hand hand:player.hands) {
                    while (true) {
                        System.out.println(player.name + " : " + hand.getScore() + ": "
                                + hand);
                        Command command = player.decision(hand);
                        System.out.println(command);
                        if (command == Command.STAND) {
                            break;
                        }
                        if(command == Command.DOUBLE)
                        {
                            dealer.deal(player,hand);
                            System.out.println(player.name + " : " + hand.getScore() + ": "
                                    + hand);
                            break;
                        }
                        if (command == Command.HIT)
                            dealer.deal(player,hand);
                    }
                }
                player.split();
        }
    }
    public void declareResults()
    {
        for(Player player: players)
        {
            if(player!= dealer)
            {
                for(Hand hand:player.hands) {
                    if (hand.getScore() > 21) {
                        Player.state = GameResult.LOSS;
                    } else if (dealer.hands.getFirst().getScore() > 21) {
                        player.state = GameResult.WIN;
                    } else if (dealer.hands.getFirst().getScore() >hand.getScore()) {
                        player.state = GameResult.LOSS;
                    } else if (dealer.hands.getFirst().getScore() < hand.getScore()) {
                        player.state = GameResult.WIN;
                    } else {
                        player.state = GameResult.DRAW;
                    }
                    if (player.state == GameResult.WIN) {
                        player.wallet += player.bet * 2;
                        if (hand.getScore() == 21) {
                            player.wallet += player.bet / 2;
                        }
                    } else if (player.state == GameResult.DRAW) {
                        player.wallet += player.bet;
                    }
                    System.out.println(player.name + " " + player.state + " with " + hand + " and with " + player.wallet + " $");
                }
            }
        }
    }
    public void checkLosers()
    {
        int []losers = new int[3];
        for(int i = 0;i<3;i++)
        {
            losers[i] = -1;
        }
        int k = 0;
        for(int i = 0;i< players.size();i++)
        {
            if(players.get(i).wallet == 0)
            {
                System.out.println(players.get(i).name+" lost");
                losers[k] = i;
                k++;
            }
        }
        for(int l:losers)
        {
            if(l!=-1)
            {
                players.remove(l);
            }
        }
    }
    public void clearHands()
    {
        for(Player player:players)
        {
            player.clearHands();
        }
        dealer.deck = new Deck();
    }
}
