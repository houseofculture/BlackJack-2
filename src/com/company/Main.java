package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Table table = new Table();
        while(true) {
            System.out.println("WANNA PLAY?");
            String s = in.nextLine();
            if("no".startsWith(s.toLowerCase()))
            {
                break;
            }
            table.makeBets();
            table.deal();
            table.game();
            table.declareResults();
            table.checkLosers();
            table.clearHands();
        }
    }
}
