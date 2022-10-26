package com.Game.Droids;

/**
 * Легкий дроїд, який компенсує скромні характеристики
 * власною швидкістю і можливістю увертатись від пострілів
 */
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
            System.out.print(getName() + " Quick reflexes reduced some damage!\n");
            setHealth(getHealth()-(damage-(1 +(int)(Math.random()*9))));
        }
    }

    @Override
    public String getType() {
        return "H";
    }
}
