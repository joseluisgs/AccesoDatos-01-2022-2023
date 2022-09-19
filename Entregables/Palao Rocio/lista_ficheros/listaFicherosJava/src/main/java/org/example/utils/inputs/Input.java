package org.example.utils.inputs;

import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    public static int menuOptions(){
    String option;
        do{
            System.out.println("""
                    1. Escribir fichero
                    2. Leer fichero
                    3. Escribir fichero en binario
                    4. Leer fichero binario
                    0. Salir""");
            option=sc.nextLine();
        }while(!option.matches("[0-4]"));
       return Integer.parseInt(option);
    }


    public static String pedirRuta(){
        System.out.println("Dime la ruta del archivo");
        return sc.nextLine();
    }
}
