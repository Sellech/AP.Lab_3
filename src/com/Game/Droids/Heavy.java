package com.Game.Droids;

/**
 * Важкий дроїд, з великим запасом броні та регенерацією,
 * але низькою швидкістю та обмеженою шкодою
 */
public class Heavy extends Droid {
    private int armor;

    public Heavy(String name){
        super(name, 100, 30, 50);
        armor = 250;
    }

    @Override
    public void getHit(int damage) {
        if (armor > 0){
            armor -= damage;
            if (armor > 0){
                armor += (int)(armor*0.10);
                System.out.print(getName() + " regenerated some armor\n");
            }
        }
        else
            setHealth(getHealth()-damage);
    }

}
