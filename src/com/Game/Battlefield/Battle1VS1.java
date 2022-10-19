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
    private void results(int i, String droidName) {
        System.out.println("\n" + droidName + " droid won! Congratulation!");
        System.out.println("Number of rounds: " + i);
    }

    /**
     * Виведення повідомлення про отримання урону
     */
    private void printHitD1(){
        System.out.println(droid_1.getName() + " get hit with " + droid_2.getDamage() + "!");
    }
    private void printHitD2(){
        System.out.println(droid_2.getName() + " get hit with " + droid_1.getDamage() + "!");
    }


    /**
     * Моделювання бою між двома дроїдами
     */
    public void fight(){
        // Якщо ініціатива першого дроїда, більша ніж у другого
        if (droid_1.getInitiative() > droid_2.getInitiative()){
            for(int i=1; ;i++){
                if(droid_2.getHealth() > 0){
                    printHitD2();
                    droid_2.getHit(droid_1.getDamage());
                }
                else {
                    results(i, droid_2.getName());
                    break;
                }
                if(droid_1.getHealth() > 0){
                    printHitD1();
                    droid_1.getHit(droid_2.getDamage());
                }
                else {
                    results(i, droid_1.getName());
                    break;
                }
                System.out.println();
            }
        }
        // Якщо ініціативність другого дроїда більша ніж у першого
        else if (droid_1.getInitiative() < droid_2.getInitiative()){
            for (int i=1; ;i++){
                if(droid_1.getHealth() > 0){
                    printHitD1();
                    droid_1.getHit(droid_2.getDamage());
                }
                else {
                    results(i, droid_1.getName());
                    break;
                }
                if(droid_2.getHealth() > 0){
                    printHitD2();
                    droid_2.getHit(droid_1.getDamage());
                }
                else {
                    results(i, droid_2.getName());
                    break;
                }
                System.out.println();
            }
        }
        // Якщо ініціатива дроїдів однакова
        else {
            if (Math.random() > Math.random()){
                for(int i=1; ;i++){
                    if(droid_2.getHealth() > 0){
                        printHitD2();
                        droid_2.getHit(droid_1.getDamage());
                    }
                    else {
                        results(i, droid_1.getName());
                        break;
                    }
                    if(droid_1.getHealth() > 0){
                        printHitD1();
                        droid_1.getHit(droid_2.getDamage());
                    }
                    else {
                        results(i, droid_2.getName());
                        break;
                    }
                    System.out.println();
                }
            }
            else {
                for (int i=1; ;i++){
                    if(droid_1.getHealth() > 0){
                        printHitD1();
                        droid_1.getHit(droid_2.getDamage());
                    }
                    else {
                        results(i, droid_2.getName());
                        break;
                    }
                    if(droid_2.getHealth() > 0){
                        printHitD2();
                        droid_2.getHit(droid_1.getDamage());
                    }
                    else {
                        results(i, droid_1.getName());
                        break;
                    }
                    System.out.println();
                }
            }
        }
    }
}
