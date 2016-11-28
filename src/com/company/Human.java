package com.company;

import java.util.Scanner;

public class Human extends Player{
    private Scanner in = new Scanner(System.in);
    public Human(Intellect intellect) {
        super(intellect);
        System.out.println("SAY YOUR NAME");
        this.name = in.nextLine();
        isSplitted = false;
    }
}
