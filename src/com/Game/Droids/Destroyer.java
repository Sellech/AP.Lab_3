package com.Game.Droids;

/**
 * Дроїд-винищувач з невеликою живучістю, але високою
 * ініціативою та можливістю увійти в режим "берсерка"
 */
public class Destroyer extends Droid{
    private int armor;

    public Destroyer(String name){
        super(name, 100, 30, 125);
        armor = 20;
    }

    @Override
    public void getHit(int damage) {
        if (armor > 0)
            armor -= damage;
        else {
            if(getDamage() == 30){
                setDamage(50);
                setHealth(getHealth()-damage);
            }
            else {
                setDamage(getDamage() + 5);
                setHealth(getHealth()-damage);
            }
        }

    }

    @Override
    public String getType() {
        return "D";
    }
}
