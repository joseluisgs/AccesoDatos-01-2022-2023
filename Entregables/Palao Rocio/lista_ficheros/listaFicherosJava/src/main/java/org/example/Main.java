package org.example;

import org.example.controller.FicherosController;
import org.example.repositories.UsuarioRepositoryImpl;
import org.example.utils.ficheros.FicherosUsuario;

/**
 * @author Rocio P.F
 * @version 1.0
 * github: Rochiio
 * Lista de usuarios que se pase a un fichero de texto y luego se lea el fichero de texto.
 * Y que lo cree o que coja el fichero ya creado.
 * También para binario.
 */
public class Main {
    public static void main(String[] args) {
        FicherosController controller = new FicherosController(new FicherosUsuario(), new UsuarioRepositoryImpl());
        controller.init();
        controller.play();
    }
}