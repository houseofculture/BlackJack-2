package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        Dealer dealer = new Dealer();
        List<Player> players = new LinkedList<>();
        players.add(new Computer(new LimitIntellect(17)));
        players.add(new Computer(new LimitIntellect(20)));
        players.add(new Human(new ConsoleIntellect()));
        players.add(dealer);

        for(Player player:players)
        {
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.hand);
        }

        for(Player player : players)
        {
            while(true)
            {
                Command command = player.decision();
                if (command == Command.STAND)
                    break;
                if (command == Command.HIT)
                    dealer.deal(player);

                System.out.println(player.hand);
            }
        }
    }
}
