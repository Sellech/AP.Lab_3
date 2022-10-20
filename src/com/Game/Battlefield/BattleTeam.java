package com.Game.Battlefield;

import com.Game.Droids.Droid;
import java.util.ArrayList;

public class BattleTeam {
    private ArrayList<Droid> blueTeam = new ArrayList<Droid>();
    private ArrayList<Droid> redTeam = new ArrayList<Droid>();

    public BattleTeam(ArrayList<Droid> blueTeam, ArrayList<Droid> redTeam){
        this.blueTeam = blueTeam;
        this.redTeam = redTeam;
    }

    /**
     * Моделювання бою між двома командами
     */
    public void fight(){
        for(int i=1; ;i++){ // раунд
            System.out.println(LINE.repeat(24) + " Round "+ i + " " + LINE.repeat(25));

            // Якщо з двох команд залишилось по дроїду
            if ((blueTeam.size() == 1) && (redTeam.size() == 1)){
                // якщо ініціатива червоного дроїда більша, ніж у синього
                if(redTeam.get(0).getInitiative() > blueTeam.get(0).getInitiative()) {
                   if (endScenarioRed(i) == 1) return;
                   if (endScenarioBlue(i) == 1) return;
                }
                // навпаки
                else if (redTeam.get(0).getInitiative() < blueTeam.get(0).getInitiative()) {
                    if (endScenarioBlue(i) == 1) return;
                    if (endScenarioRed(i) == 1) return;
                }
                //якщо ініціатива рівна
                else {
                    if(Math.random() > 0.5){
                        if (endScenarioRed(i) == 1) return;
                        if (endScenarioBlue(i) == 1) return;
                    }
                    else {
                        if (endScenarioBlue(i) == 1) return;
                        if (endScenarioRed(i) == 1) return;
                    }
                }
            }
            // Якщо в синій команді залишається лише один дроїд
            else if(blueTeam.size() == 1){
                scenarioBlue(0);    // спершу ходить синій
                if (endScenarioRed(i) == 1) return;
            }
            // Якщо в червоній команді залишається лише один дроїд
            else if (redTeam.size() == 1){
                scenarioRed(0);    // спершу ходить червоний
                if (endScenarioBlue(i) == 1) return;
            }
            else {
                for(int j=0; j < blueTeam.size();j++){
                    if (i % 2 == 1) {   // у непарних раундах синя команда ходить перша
                        // Хід робота з команди синіх
                        if (j < blueTeam.size()) {   // перевірка чи дроїд з таким індексом є в команді
                            scenarioBlue(j);
                        }
                        // Хід робота з команди червоних
                        if (j < redTeam.size()) {
                            scenarioRed(j);
                        }
                        System.out.println();
                    }
                    else {  // у парних раундах червона команда ходить перша
                        if (j < redTeam.size()) {
                            scenarioRed(j);
                        }
                        if (j < blueTeam.size()) {
                            scenarioBlue(j);
                        }
                        System.out.println();
                    }
                }
            }
        }

    }

    /**
     * Виведення повідомлення про отримання шкоди
     */
    private void printHit(Droid defender, Droid attacker){
        System.out.println(defender.getName() + " get hit with " + attacker.getDamage() + "!");
    }

    /**
     * Виведення повідомлення про знищення дроїда
     */
    private void printLooser(Droid looser){
        System.out.println("\t" + looser.getName() + BLACK + " was destroyed..." + RESET);
    }

    /**
     * Виведення результатів бою між командами
     */
    private void resultsRed(int i) {
        System.out.println(LINE.repeat(24)+PURPLE+" Results "+RESET+LINE.repeat(25));
        System.out.println(RED + "\n" + "Red droid-team won! Congratulation!" + RESET);
        System.out.println("Number of rounds: " + i);
    }

    private void resultsBlue(int i) {
        System.out.println(LINE.repeat(24)+PURPLE+" Results "+RESET+LINE.repeat(25));
        System.out.println(BLUE + "\n" + "Blue droid-team won! Congratulation!" + RESET);
        System.out.println("Number of rounds: " + i);
    }

    /**
     * Сценарій ходу синього дроїда
     */
    private void scenarioBlue(int j){
        for (; ; ) {
            int num = (int) (Math.random() * redTeam.size()); // обираємо випадкового дроїда
            if (redTeam.get(num).getHealth() > 0) {
                printHit(redTeam.get(num), blueTeam.get(j));
                redTeam.get(num).getHit(blueTeam.get(j).getDamage());
                break;
            } else {
                printLooser(redTeam.get(num));
                redTeam.remove(num);
            }
        }
    }

    /**
     * Сценарій ходу червоного дроїда
     */
    private void scenarioRed(int j){
        for (; ; ) {    //стріляє дроїд команди червоних
            int num = (int) (Math.random() * blueTeam.size());
            if (blueTeam.get(num).getHealth() > 0) {
                printHit(blueTeam.get(num), redTeam.get(j));
                blueTeam.get(num).getHit(redTeam.get(j).getDamage());
                break;
            } else {
                printLooser(blueTeam.get(num));
                blueTeam.remove(num);
            }
        }
    }

    /**
     * Сценарій ходу синьої команди, коли у ворогів залишається лише один дроїд
     */

    private int endScenarioBlue(int i) {
        for(int j=0; j < blueTeam.size(); j++) {
            for (; ; ) {
                int num = (int) (Math.random() * redTeam.size()); // обираємо випадкового дроїда
                if (redTeam.get(num).getHealth() > 0) {
                    printHit(redTeam.get(num), blueTeam.get(j));
                    redTeam.get(num).getHit(blueTeam.get(j).getDamage());
                    break;
                }
                else {
                    printLooser(redTeam.get(num));
                    resultsBlue(i);
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * Сценарій ходу червоної команди, коли у ворогів залишається лише один дроїд
     */
    private int endScenarioRed(int i) {
        for(int j=0; j < redTeam.size(); j++) {
            for (; ; ) {
                int num = (int) (Math.random() * blueTeam.size());
                if (blueTeam.get(num).getHealth() > 0) {
                    printHit(blueTeam.get(num), redTeam.get(j));
                    blueTeam.get(num).getHit(redTeam.get(j).getDamage());
                    break;
                }
                else {
                    printLooser(blueTeam.get(num));
                    resultsRed(i);
                    return 1;
                }
            }
        }
        return 0;
    }


    private static final String LINE = "=";
    private static final String RESET = "\u001B[0m";
    private static final String BLACK = "\u001B[30m";
    private static final String PURPLE = "\u001B[35m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
}
