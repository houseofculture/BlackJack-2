package com.company;

/**
 * Created by student2 on 18.11.16.
 */
public class LimitIntellect extends Intellect {
    public LimitIntellect(int limit) {
        this.limit = limit;
    }
    private int limit;
    public Command decide(int score){
        if(score<limit)
            return Command.HIT;
        else
            return Command.STAND;
    }

    public boolean dbl() {
        double n = Math.random();
        if(n>0.5)
        {
            return true;
        }
        return false;
    }
}
