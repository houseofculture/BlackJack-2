package com.company;

import java.util.Scanner;

public class Human extends Player {
    private Scanner in = new Scanner(System.in);

    public Human(Intellect intellect, Better better) {
        super(intellect, better);
    }
}