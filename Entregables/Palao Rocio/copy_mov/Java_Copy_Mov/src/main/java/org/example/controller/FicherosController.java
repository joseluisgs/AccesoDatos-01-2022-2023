package org.example.controller;

import org.example.utils.Input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FicherosController {
    private final Input input;


    /**
     * Constructor
     * @param input Clase necesaria para pedir datos
     */
    public FicherosController(Input input) {
        this.input = input;
    }


    /**
     * Para preguntar por el comando, y realizar todas las acciones.
     */
    public void startCommand(){
        var line =input.getStringPath();
        var separado = line.split(" ");
        Path inicialPath = Paths.get(separado[1]).toAbsolutePath();
        Path finalPath = Paths.get(separado[2]).toAbsolutePath();

        if(rutaInicialCorrecta(inicialPath)) {
            selectComand(separado[0], inicialPath, finalPath);
        }
    }


    /**
     * Para saber si la ruta inicial dada existe.
     * @param inicialPath ruta inicial.
     * @return si existe o no.
     */
    private boolean rutaInicialCorrecta(Path inicialPath) {
        return Files.exists(inicialPath);
    }


    /**
     * Crear la ruta final.
     * @param line ruta final.
     */
    private void createFinalPath(Path line) {
       if (Files.notExists(line)){
           try {
               Files.createDirectories(line);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }
    }


    /**
     * Para seleccionar si es copiar o mover.
     * @param comando contiene si es copiar o mover.
     * @param inicialPath ruta inicial del fichero.
     * @param finalPath ruta final del fichero.
     */
    private void selectComand(String comando, Path inicialPath, Path finalPath){
        if (comando.equals("cp")){
            makeCp(inicialPath, finalPath);
        }else{
            makeMv(inicialPath, finalPath);
        }
    }


    /**
     * Mover el fichero de la ruta inicial a la ruta final.
     * @param rutaInicial ruta inicial del fichero.
     * @param rutaFinal ruta final del fichero.
     */
    private void makeMv(Path rutaInicial, Path rutaFinal) {
        try {
            Files.move(rutaInicial, rutaFinal, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Copiar el fichero desde la ruta inicial hasta la ruta final.
     * @param rutaInicial ruta inicial del fichero.
     * @param rutaFinal ruta final del fichero.
     */
    private void makeCp(Path rutaInicial, Path rutaFinal) {
        if(Files.exists(rutaFinal)){
            if (!input.sobreescribirArchivo()){
                System.out.println("No sé copió el archivo");
                return;
            }
        }else{
            createFinalPath(rutaFinal);
        }

        try {
            Files.copy(rutaInicial,rutaFinal,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
