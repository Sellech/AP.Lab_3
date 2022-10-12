package com.Game.Battlefield;

import com.Game.Droids.Droid;

public class Battle1VS1 {
    private Droid droid_1;
    private Droid droid_2;

    public Battle1VS1(Droid droid_1, Droid droid_2){
        this.droid_1 = droid_1;
        this.droid_2 = droid_2;
    }

    /**
     * Виведення на екран результатів бою
     */
    public void results(int i, int num){
        System.out.println("\n Переміг дроїд №" + num + ". Кількість раундів: " + i/2);
    }

    /**
     * Моделювання бою між двома дроїдами
     */
    public void fight(){
        // Якщо ініціатива першого дроїда, більша ніж у другого
        if (droid_1.getInitiative() > droid_2.getInitiative()){
            for(int i=1; ; i++){
                if(i%2 == 0){
                    if(droid_1.getHealth() > 0){
                        droid_1.getHit(droid_2.getDamage());
                        System.out.println("get hit with " + droid_2.getDamage());
                    }
                    else {
                        results(i, 2);
                        break;
                    }
                }
                else{
                    if(droid_2.getHealth() > 0){
                        droid_2.getHit(droid_1.getDamage());
                        System.out.println("get hit with " + droid_2.getDamage());
                    }
                    else {
                        results(i, 1);
                        break;
                    }
                }
            }
        }
        // Якщо ініціативність другого дроїда більша ніж у першого
        else {
            for(int i=1; ; i++){
                if(i%2 == 0){
                    if(droid_2.getHealth() > 0){
                        droid_2.getHit(droid_1.getDamage());
                        System.out.println("get hit with " + droid_2.getDamage());
                    }
                    else {
                        results(i, 2);
                        break;
                    }
                }
                else{
                    if(droid_1.getHealth() > 0){
                        droid_1.getHit(droid_2.getDamage());
                        System.out.println("get hit with " + droid_2.getDamage());
                    }
                    else {
                        results(i, 1);
                        break;
                    }
                }
            }
        }
    }
}
