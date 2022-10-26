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
    private void results(int i, String winner, String looser) {
        System.out.println(looser + BLACK + " was destroyed..." + RESET);
        System.out.println(LINE.repeat(24)+PURPLE+" Results "+RESET+LINE.repeat(25));
        System.out.println(YELLOW + "\n" + winner + " droid won! Congratulation!" + RESET);
        System.out.println("Number of rounds: " + i);
    }

    /**
     * Виведення повідомлення про отримання шкоди
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
            scenario_1();
        }
        // Якщо ініціативність другого дроїда більша ніж у першого
        else if (droid_1.getInitiative() < droid_2.getInitiative()){
            scenario_2();
        }
        // Якщо ініціатива дроїдів однакова
        else {
            if (Math.random() > 0.5){
                scenario_1();
            }
            else {
                scenario_2();
            }
        }
    }

    /**
     * Сценарій бою у випадку, якщо ініціатива першого дроїда вища
     */
    public void scenario_1(){
        for(int i=1; ;i++){
            System.out.println(LINE.repeat(24) + " Round "+ i + " " + LINE.repeat(25));
            if(droid_2.getHealth() > 0){
                printHitD2();
                droid_2.getHit(droid_1.getDamage());
            }
            else {
                results(i, droid_2.getName(), droid_1.getName());
                break;
            }
            if(droid_1.getHealth() > 0){
                printHitD1();
                droid_1.getHit(droid_2.getDamage());
            }
            else {
                results(i, droid_1.getName(),droid_2.getName());
                break;
            }
            System.out.println();

            try {    // затримка виведення результатів раунду
                Thread.sleep(2000);
            } catch (InterruptedException e){
            }
        }
    }

    /**
     * Сценарій бою у випадку, якщо ініціатива другого дроїда вища
     */
    public void scenario_2(){
        for (int i=1; ;i++){
            System.out.println(LINE.repeat(24) + " Round "+ i + " " + LINE.repeat(25));
            if(droid_1.getHealth() > 0){
                printHitD1();
                droid_1.getHit(droid_2.getDamage());
            }
            else {
                results(i, droid_2.getName(), droid_2.getName());
                break;
            }
            if(droid_2.getHealth() > 0){
                printHitD2();
                droid_2.getHit(droid_1.getDamage());
            }
            else {
                results(i, droid_1.getName(), droid_2.getName());
                break;
            }
            System.out.println();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }

    private static final String LINE = "=";
    private static final String RESET = "\u001B[0m";
    private static final String BLACK = "\u001B[30m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";
}
