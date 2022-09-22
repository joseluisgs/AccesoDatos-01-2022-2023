package org.example;


import org.example.controller.FicherosController;
import org.example.utils.Input;
//TODO da constantemente errores y ya no sé porqué
/**
 * @author Rocío P.F
 * @version 1.0
 * github: Rochiio
 * Aplicación que copie y mueva ficheros
 */
public class Main{
    public static void main(String[] args){
        FicherosController controller = new FicherosController(new Input());
        controller.startCommand();
    }
}