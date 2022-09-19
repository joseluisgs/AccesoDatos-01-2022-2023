package org.example.controller;

import org.example.repositories.UsuarioRepository;
import org.example.utils.ficheros.FicherosUsuario;
import org.example.utils.inputs.Input;

import java.nio.file.Files;
import java.nio.file.Path;


public class FicherosController {
    FicherosUsuario ficheros;
    UsuarioRepository repository;

    public FicherosController(FicherosUsuario ficheros, UsuarioRepository repository) {
        this.ficheros = ficheros;
        this.repository = repository;
    }

    public void init(){
        repository.addFirstData();
    }

    public void play(){
    int option;
        do {
            option= Input.menuOptions();
            opciones(option);

        }while(option!=0);
    }

    private void opciones(int option) {
        switch (option){
            case 1: escribirFichero();
            break;
            case 2: leerFichero();
            break;
            case 3: escribirBinario();
            break;
            case 4: leerBinario();
        }
    }


    /**
     * Leer un fichero binario
     */
    private void leerBinario() {
        var fichero = Input.pedirRuta();
        if (!Files.exists(Path.of(fichero))){
            System.out.println("Error de ruta");
        }else{
            var lista = ficheros.getFicheroBinary(fichero);
            lista.forEach(System.out::println);
        }
    }


    /**
     * Escirbir un fichero binario
     */
    private void escribirBinario() {
        var fichero = Input.pedirRuta();
        ficheros.createIfNotExists(fichero);
        ficheros.addToFicheroBinary(repository.getData(),fichero);
        System.out.println("Fichero binario escrito");
    }


    /**
     * Leer un fichero de texto.
     */
    private void leerFichero() {
        var fichero = Input.pedirRuta();
        if (!Files.exists(Path.of(fichero))){
            System.out.println("Error de ruta");
        }else{
            var lista = ficheros.getFicheroText(fichero);
            lista.forEach(System.out::println);
        }
    }


    /**
     * Escribir en un fichero de texto.
     */
    private void escribirFichero() {
        var fichero = Input.pedirRuta();
        ficheros.createIfNotExists(fichero);
        ficheros.addToFicheroText(repository.getData(),fichero);
        System.out.println("Fichero escrito");
    }


}
