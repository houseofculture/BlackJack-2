package com.company;

import java.util.Scanner;

public class Human extends Player {
    Scanner in = new Scanner(System.in);

    public Human(Intellect intellect, Better better) {
        super(intellect, better);
        System.out.println("WHAT'S YOUR NAME, HONEY?");
        name = in.nextLine();
    }
}