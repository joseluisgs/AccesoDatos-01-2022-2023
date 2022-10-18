package es.joseluisgs.dam;

import java.awt.*;
import java.io.File;
import java.net.URI;

public class Main {

    public static void main(String[] args) {
        // abrir una aplicacion
        /*Runtime aplicacion = Runtime.getRuntime();
        try{
            aplicacion.exec("c:\\Program Files (x86)\\Notepad++\\notepad++.exe "+fichero2.getAbsolutePath());
            aplicacion.exec("c:\\Program Files (x86)\\Notepad++\\notepad++.exe "+fichero2.getAbsolutePath());
        }
        catch(Exception e)
        {
            System.err.println(e);
        }*/

        Desktop app = Desktop.getDesktop();
        try{
            app.edit(new File("prueba.txt"));
            app.mail();
            app.browse(new URI("https://joseluisgs.github.io/"));
            app.print(new File("prueba.txt"));
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
}
