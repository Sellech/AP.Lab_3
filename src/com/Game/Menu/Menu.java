package com.Game.Menu;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;
import com.Game.Battlefield.Battle1VS1;
import com.Game.Droids.Droid;
import com.Game.Droids.Medium;
import com.Game.Droids.Light;


public class Menu {
    private int option;

    public void runMenu(){
        Scanner in = new Scanner(System.in);

        System.out.println("\nWelcome to Battle Droids Game!");
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

    private void startBattle1VS1(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nChoose droids:");
        System.out.println("\t1) Light\n\t2) Medium\n\t3) Heavy\n\t4) Destroyer\n\t5) Supporter\n\t6) Exit");

        ArrayList<Droid> droidList = new ArrayList<Droid>();
        for(int i=0; i<2;i++){
            option = in.nextInt();
            switch (option){
                case 1 -> {
                    Light droid = new Light(inputDroidName(i+1));
                    droidList.add(droid);
                }
                case 2 -> {
                    Medium droid = new Medium(inputDroidName(i+1));
                    droidList.add(droid);
                }

                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> runMenu();
            }
        }
        Battle1VS1 battle = new Battle1VS1(droidList.get(0), droidList.get(1));
        battle.fight();
    }

    private void startBattleTeam(){

    }

    private void startBattleFile(){

    }

    private String inputDroidName(int num) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter droid-" + num + " name: ");
        String droidName = in.nextLine();
        return(droidName);
    }


}
