package com.company;

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

    public void setBets()
    {
        for(Player player:players)
        {
            player.setBet();
        }
    }

    public void deal()
    {
        for (Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.name +" : "+ player.hand);
            if(player.hand.getFirst().value == player.hand.getLast().value)
            {
                player.split();
            }
        }
    }
    public void game()
    {
        for (Player player : players) {
            while (true) {
                System.out.println(player.name + " : " + player.hand.getScore() + ": "
                        + player.hand);
                Command command = player.decision();
                System.out.println(command);
                if (command == Command.STAND) {
                    break;
                }
                if (command == Command.HIT)
                    dealer.deal(player);
                if(player.isSplitted)
                {
                    while(true) {
                        System.out.println(player.name + " : " + player.hand2.getScore() + ": "
                                + player.hand2);
                        command = player.decision2();
                        System.out.println(command);
                        if (command == Command.STAND) {
                            break;
                        }
                        if (command == Command.HIT)
                            dealer.deal2(player);
                    }
                }
            }
        }
    }
    public void declareResults()
    {
        for(Player player: players)
        {
            if(player!= dealer)
            {
                if(player.hand.getScore()>21)
                {
                    Player.state = GameResult.LOSS;
                }
                else if(dealer.hand.getScore()>21)
                {
                    player.state = GameResult.WIN;
                }
                else if(dealer.hand.getScore()>player.hand.getScore())
                {
                    player.state = GameResult.LOSS;
                }
                else if(dealer.hand.getScore()<player.hand.getScore())
                {
                    player.state = GameResult.WIN;
                }
                else
                {
                    player.state = GameResult.DRAW;
                }
                System.out.println(player.name+" " +player.state+" with "+player.hand);
                if(player.isSplitted)
                {
                    if(player.hand2.getScore()>21)
                    {
                        Player.state = GameResult.LOSS;
                    }
                    else if(dealer.hand.getScore()>21)
                    {
                        player.state = GameResult.WIN;
                    }
                    else if(dealer.hand.getScore()>player.hand2.getScore())
                    {
                        player.state = GameResult.LOSS;
                    }
                    else if(dealer.hand.getScore()<player.hand2.getScore())
                    {
                        player.state = GameResult.WIN;
                    }
                    else
                    {
                        player.state = GameResult.DRAW;
                    }
                    System.out.println(player.name+" " +player.state+" with "+player.hand2);
                    if(player.state == GameResult.WIN)
                    {

                    }
                }
            }
        }
    }
    public void clearHands()
    {
        for(Player player:players)
        {
            player.hand.clear();
        }
    }
}