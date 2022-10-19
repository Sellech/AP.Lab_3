package com.Game.Droids;

public class Light extends Droid{

    public Light(String name){
        super(name, 140, 20, 150);
    }

    @Override
    public void getHit(int damage) {
        if ((getHealth() > 100)&&(Math.random() < 0.7))
            System.out.print(getName() + " dodges the damage!\n");
        else if (Math.random() < 0.4)
            System.out.print(getName() + " dodges the damage!\n");
        else {
            setHealth(getHealth()-damage);
        }
    }
}
