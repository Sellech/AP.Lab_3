package com.Game.Droids;

public class Medium extends Droid {
    private int armor;

    public Medium(){
        super("R1 Середній", 150, 40, 100);
        armor = 100;
    }

    @Override
    public void getHit(int damage) {
        if (armor > 0)
            armor -= damage;

        else
            setHealth(getHealth()-damage);
    }
}
