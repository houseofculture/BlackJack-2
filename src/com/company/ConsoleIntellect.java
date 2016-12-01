package com.company;


import java.util.Scanner;

public class ConsoleIntellect extends Intellect
{
    private Scanner in = new Scanner(System.in);

    @Override
    public Command decide(int score) {
        while (true) {
            System.out.println("HIT/STAND?");
            String s = in.nextLine();
            if ("hit".startsWith(s.toLowerCase())) {
                return Command.HIT;
            }
            if ("stand".startsWith(s.toLowerCase())) {
                return Command.STAND;
            }
            System.out.println("Can't understand,please repeat");
        }
    }
}