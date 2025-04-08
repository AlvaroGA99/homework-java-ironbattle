package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Character startBattle(Attacker a, Attacker b){
        Character winner = null;
        Character aChar = (Character) a;
        Character bChar = (Character) b;
        int originalHpA = aChar.getHp();
        int originalHpB = bChar.getHp();
        boolean fighting = true;
        while (fighting) {
            a.attack(aChar);
            b.attack(bChar);
            if(!aChar.isAlive() && !bChar.isAlive()){
                aChar.setAlive(true);
                aChar.setHp(originalHpA);
                bChar.setAlive(true);
                bChar.setHp(originalHpB);
                System.out.println("Ambos personajes han muerto, se reinicia la batalla hasta encontrar un ganador");
                continue;
            }else{
                if(!aChar.isAlive()){
                    winner = bChar;
                    fighting = false;
                }else if(!bChar.isAlive()){
                    winner = aChar;
                    fighting = false;
                }
            }
        }

        return winner;
    }

    public static Warrior initWarrior(Scanner scanner){
        System.out.println("Introduce el nombre del Guerrero");
        String name = scanner.next();
        System.out.println("Introduce la vida del Guerrero");
        int hp = readAttribute(scanner);
        System.out.println("Introduce la stamina del Guerrero");
        int stamina = readAttribute(scanner);
        System.out.println("Introduce la fuerza del Guerrero");
        int strength = readAttribute(scanner);
        return new Warrior(name, hp, stamina, strength);
    }

    public static Wizard initWizard(Scanner scanner){
        System.out.println("Introduce el nombre del Mago");
        String name = scanner.next();
        System.out.println("Introduce la vida del Mago");
        int hp = readAttribute(scanner);
        System.out.println("Introduce el mana del Mago");
        int mana = readAttribute(scanner);;
        System.out.println("Introduce la inteligencia del Guerrero");
        int intelligence = readAttribute(scanner);;
        return new Wizard(name, hp, mana, intelligence);
    }

    public static int readAttribute(Scanner scanner){
        int attribute = 0;
        while(true) {
            if(scanner.hasNextInt()) {
                attribute = scanner.nextInt();
                break;
            }else{
                System.out.println("Debes introducir un número");
                scanner.next();
            }
        }
        return attribute;
    }


    public static void main(String[] args) {

        // hacer batalla
        // salir
        boolean executing = true;
        boolean validOption = false;
        var scanner = new Scanner(System.in);


        System.out.println("Bienvenido a Iron Battle. Elige una opción : \n");
        while(executing){

            System.out.println("1 - Batalla");
            System.out.println("2 - Salir");

            switch(scanner.nextInt()){
                case 1 :
                    while(!validOption) {


                        System.out.println("1 - Crear personajes manualmente");
                        System.out.println("2 - Crear personajes aleatoriamente");
                        System.out.println("3 - Importar personajes desde CSV");

                        switch (scanner.nextInt()) {
                            case 1:
                                Attacker a = null;
                                Attacker b = null;

                                while(!validOption){
                                    System.out.println("Añade al primer combatiente\n");
                                    //switch para elegir entre Guerrero y Mago
                                    System.out.println("1 - Guerrero");
                                    System.out.println("2 - Mago");
                                    switch (scanner.nextInt()) {
                                        case 1:
                                            a = initWarrior(scanner);
                                            validOption = true;
                                            break;
                                        case 2:
                                            a = initWizard(scanner);
                                            validOption = true;
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                    }
                                }

                                validOption = false;

                                while(!validOption) {
                                    System.out.println("Añade al segundo combatiente\n");
                                    //switch para elegir entre Guerrero y Mago
                                    System.out.println("1 - Guerrero");
                                    System.out.println("2 - Mago");
                                    switch (scanner.nextInt()) {
                                        case 1:
                                            b = initWarrior(scanner);
                                            validOption = true;
                                            break;
                                        case 2:
                                            b = initWizard(scanner);
                                            validOption = true;
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                    }
                                }

                                Character winner = startBattle(a,b);
                                System.out.println("El ganador es: " + winner.getName());
                                break;
                            case 2:
                                validOption = true;
                                break;
                            case 3:
                                validOption = true;
                                break;
                            default:
                                System.out.println("Opción no válida");
                                validOption = false;
                                break;
                        }
                    }
                    validOption = false;
                    break;
                case 2 :
                    executing = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}