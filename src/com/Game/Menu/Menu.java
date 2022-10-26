package com.Game.Menu;

import java.util.ArrayList;
import java.util.Scanner;
import com.Game.Battlefield.*;
import com.Game.Droids.*;
import java.io.*;

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

    /**
     * Метод для запуску бою команда на команду
     */

    private void startBattleTeam(){
        Scanner in = new Scanner(System.in);
        System.out.println("\n"+LINE.repeat(12)+PURPLE+" Choose number of droid in team: "+RESET+LINE.repeat(13));
        int droidNum = 2*(in.nextInt());

        System.out.println("\n"+LINE.repeat(21)+PURPLE+" Choose droids: "+RESET+LINE.repeat(21));
        System.out.println("\t1) Light\n\t2) Medium\n\t3) Heavy\n\t4) Destroyer\n\t5) Exit");

        ArrayList<Droid> blueTeam = new ArrayList<Droid>();
        ArrayList<Droid> redTeam = new ArrayList<Droid>();

        for(int i=1; i<=droidNum;i++){
            option = in.nextInt();

            switch (option){
                case 1 -> {
                    Light droid = new Light(inputDroidName(i));
                    if(i%2 == 1)
                        blueTeam.add(droid);
                    else
                        redTeam.add(droid);
                }
                case 2 -> {
                    Medium droid = new Medium(inputDroidName(i));
                    if(i%2 == 1)
                        blueTeam.add(droid);
                    else
                        redTeam.add(droid);
                }
                case 3 -> {
                    Heavy droid = new Heavy(inputDroidName(i));
                    if(i%2 == 1)
                        blueTeam.add(droid);
                    else
                        redTeam.add(droid);
                }
                case 4 -> {
                    Destroyer droid = new Destroyer(inputDroidName(i));
                    if(i%2 == 1)
                        blueTeam.add(droid);
                    else
                        redTeam.add(droid);
                }
                case 5 -> runMenu();
            }
        }

        System.out.println("\n"+LINE.repeat(17)+RED+" The battle has begun! "+RESET+LINE.repeat(18));
        BattleTeam battle = new BattleTeam(blueTeam, redTeam);
        battle.fight();
        runMenu();
    }

    /**
     * Метод для запуску бою з файлів
     */

    private void startBattleFile(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the file path: ");    // C:\Users\chepy\Desktop\test_1.txt
        String filePath = in.nextLine();

        try(FileInputStream file = new FileInputStream(filePath))
        {
            byte[] buffer = new byte[file.available()];
            file.read(buffer, 0, file.available());

            // Спершу, визначаємо режим бою
            String gameMode = "";
            for(int i=0; i<4; i++){
                gameMode += (char)buffer[i];
            }
            System.out.println(gameMode);

            if(gameMode.equals("1vs1")){
                ArrayList<Droid> droidList = new ArrayList<Droid>();
                int counter = 0;

                for(int i=4; i < buffer.length;){
                    if((char)buffer[i] == ' ') {    // Зчитуємо новий дроїд
                        int droidNameLength = 0;
                        String droidName = "";

                        for(int j=i+3; (char)buffer[j] != ' '; j++){
                            droidName += (char)buffer[j];   // Спершу визначаємо ім'я робота
                            droidNameLength++;
                        }

                        if(counter%2 == 1)
                            droidName = BLUE + droidName + RESET;
                        else
                            droidName = RED + droidName + RESET;

                        switch((char)buffer[i+1]) { // Далі створюємо дроїда
                            case 'L' -> {
                                Light droid = new Light(droidName);
                                droidList.add(droid);
                            }
                            case 'M' -> {
                                Medium droid = new Medium(droidName);
                                droidList.add(droid);
                            }
                            case 'H' -> {
                                Heavy droid = new Heavy(droidName);
                                droidList.add(droid);
                            }
                            case 'D' -> {
                                Destroyer droid = new Destroyer(droidName);
                                droidList.add(droid);
                            }
                        }
                        i += 3 + droidNameLength;
                        counter++;
                        if(counter == 2)
                            break;
                    }
                }
                System.out.println("\n"+LINE.repeat(17)+PURPLE+" File read successfully! "+RESET+LINE.repeat(16));
                Battle1VS1 battle = new Battle1VS1(droidList.get(0), droidList.get(1));
                battle.fight();
                runMenu();
            }
            else {  // C:\Users\chepy\Desktop\test_2.txt
                String temp = "";
                temp += (char)buffer[5];    // зчитуємо символ, який відповідає за розмір команди
                int droidNum = Integer.parseInt(temp);

                ArrayList<Droid> blueTeam = new ArrayList<Droid>();
                ArrayList<Droid> redTeam = new ArrayList<Droid>();

                int counter = 0;

                for(int i=6; i < buffer.length;){
                    if((char)buffer[i] == ' ') {    // Зчитуємо новий дроїд
                        int droidNameLength = 0;
                        String droidName = "";

                        for(int j=i+3; (char)buffer[j] != ' '; j++){
                            droidName += (char)buffer[j];   // Спершу визначаємо ім'я робота
                            droidNameLength++;
                        }

                        if(counter%2 == 1)
                            droidName = BLUE + droidName + RESET;
                        else
                            droidName = RED + droidName + RESET;

                        switch((char)buffer[i+1]) { // Далі створюємо дроїда
                            case 'L' -> {
                                Light droid = new Light(droidName);
                                if(counter%2 == 1)
                                    blueTeam.add(droid);
                                else
                                    redTeam.add(droid);
                            }
                            case 'M' -> {
                                Medium droid = new Medium(droidName);
                                if(counter%2 == 1)
                                    blueTeam.add(droid);
                                else
                                    redTeam.add(droid);
                            }
                            case 'H' -> {
                                Heavy droid = new Heavy(droidName);
                                if(counter%2 == 1)
                                    blueTeam.add(droid);
                                else
                                    redTeam.add(droid);
                            }
                            case 'D' -> {
                                Destroyer droid = new Destroyer(droidName);
                                if(counter%2 == 1)
                                    blueTeam.add(droid);
                                else
                                    redTeam.add(droid);
                            }
                        }
                        i += 3 + droidNameLength;
                        counter++;
                        if(counter == droidNum*2)
                            break;
                    }
                }
                System.out.println("\n"+LINE.repeat(17)+PURPLE+" File read successfully! "+RESET+LINE.repeat(16));
                BattleTeam battle = new BattleTeam(blueTeam, redTeam);
                battle.fight();
                runMenu();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Введення унікального імені дроїду
     */
    private String inputDroidName(int num) {
        Scanner in = new Scanner(System.in);    // Візуалізація розподілу дроїдів на команди через колір
        if (num%2 == 1){
            System.out.print("Enter "+BLUE+"droid-"+num+RESET+" name: ");
            String droidName = in.nextLine();
            return(BLUE.concat(droidName).concat(RESET));
        }
        else {
            System.out.print("Enter "+RED+"droid-"+num+RESET+" name: ");
            String droidName = in.nextLine();
            return(RED.concat(droidName).concat(RESET));
        }
    }

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String LINE = "=";
}
