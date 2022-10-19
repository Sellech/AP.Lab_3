package com.Game.Menu;

import java.util.ArrayList;
import java.util.Scanner;
import com.Game.Battlefield.Battle1VS1;
import com.Game.Droids.*;


public class Menu {
    private int option;

    public void runMenu(){
        Scanner in = new Scanner(System.in);

        System.out.println("\n"+LINE.repeat(13)+PURPLE+" Welcome to Battle Droids Game! "+RESET+LINE.repeat(13));
        System.out.println("\t1) Start battle 1 vs 1");
        System.out.println("\t2) Start battle team vs team");
        System.out.println("\t3) Play battle from a .txt file");
        System.out.println("\t4) Exit game");

        option = in.nextInt();
        switch(option) {
            case 1 -> startBattle1VS1();
            case 2 -> startBattleTeam();
            case 3 -> startBattleFile();
            case 4 -> System.exit(1);

        }
    }

    /**
     * Метод для запуску бою 1 на 1
     */
    private void startBattle1VS1(){
        Scanner in = new Scanner(System.in);
        System.out.println("\n"+LINE.repeat(21)+PURPLE+" Choose droids: "+RESET+LINE.repeat(21));
        System.out.println("\t1) Light\n\t2) Medium\n\t3) Heavy\n\t4) Destroyer\n\t5) Exit");

        ArrayList<Droid> droidList = new ArrayList<Droid>();
        for(int i=1; i<=2;i++){
            option = in.nextInt();
            switch (option){
                case 1 -> {
                    Light droid = new Light(inputDroidName(i));
                    droidList.add(droid);
                }
                case 2 -> {
                    Medium droid = new Medium(inputDroidName(i));
                    droidList.add(droid);
                }
                case 3 -> {
                    Heavy droid = new Heavy(inputDroidName(i));
                    droidList.add(droid);
                }
                case 4 -> {
                    Destroyer droid = new Destroyer(inputDroidName(i));
                    droidList.add(droid);
                }
                case 5 -> runMenu();
            }
        }

        System.out.println("\n"+LINE.repeat(17)+RED+" The battle has begun! "+RESET+LINE.repeat(18));
        Battle1VS1 battle = new Battle1VS1(droidList.get(0), droidList.get(1));
        battle.fight();
        runMenu();
    }

    private void startBattleTeam(){

    }

    private void startBattleFile(){

    }

    /**
     * Введення унікального імені дроїду
     */
    private String inputDroidName(int num) {
        Scanner in = new Scanner(System.in);
        if (num%2 == 1)     // Візуалізація розподілу дроїдів на команди через колір
            System.out.print("Enter "+BLUE+"droid-"+num+RESET+" name: ");
        else
            System.out.print("Enter "+RED+"droid-"+num+RESET+" name: ");
        String droidName = in.nextLine();
        return(droidName);
    }

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String LINE = "=";
   /*
    private static final String GREEN = "\u001B[32m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREY = "\u001B[37m";
    */
}
