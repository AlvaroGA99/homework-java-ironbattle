package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Character> chars = new ArrayList<>();
        Character warrior = new Character("Char", 100) {
        };

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
                                validOption = true;
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