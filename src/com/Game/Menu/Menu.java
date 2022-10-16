package com.Game.Menu;

import java.io.Console;
import java.util.Scanner;
import com.Game.Battlefield.Battle1VS1;
import com.Game.Droids.Medium;


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
            case 1:
                startBattle1VS1();
                break;
            case 2:
                startBattleTeam();
                break;
            case 3:
                startBattleFile();
                break;
            case 4:
                System.exit(1);

        }
    }

    private void startBattle1VS1(){

    }

    private void startBattleTeam(){

    }

    private void startBattleFile(){

    }

}
