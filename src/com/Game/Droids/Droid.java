package com.Game.Droids;

public abstract class Droid {
    private String name;
    private int health;
    private int damage;
    private int initiative;

    public Droid(String name, int health, int damage, int initiative){
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.initiative = initiative;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getInitiative() {
        return initiative;
    }

    protected abstract int getHit(int damage);
}
