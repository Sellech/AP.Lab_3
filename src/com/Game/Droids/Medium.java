package com.Game.Droids;

public class Medium extends Droid {
    private int armor;

    public Medium(String name){
        super(name, 150, 40, 100);
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
