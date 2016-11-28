package com.company;


/**
 * Created by student2 on 14.11.16.
 */
public class Computer extends Player
{
    String[] names = { "СТЁПА","CНЕЖАНА","АНГЕЛИНА","ЖЕНИОУС","труигрок","DAT BOI","HARAMBE","PEPE"};
    public Computer(Intellect intellect,Better better)
    {
        super(intellect,better);
        this.name = names[(int)(Math.random()*names.length)];
        isSplitted = false;
    }
}
