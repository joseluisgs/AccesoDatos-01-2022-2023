package es.joseluisgs.dam;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, IOException {


        //Creamos objetos File
        //Asegurate que existan
        File fichero=new File("06-FicherosDirectorios.iml"); // Debe existir
        File fichero2=new File("fichero.txt");
        File directorio=new File("src"); // Debe existir y llenalo de coSAS
        File directorio2=new File("directorio");


        //Indica si existen los archivos
        System.out.println("Existencia: ");
        System.out.println("Fichero "+fichero.exists());
        System.out.println("Directorio "+directorio.exists());

        System.out.println("");

        //Indica si son directorios
        System.out.println("¿Son directorios?: ");
        System.out.println("Fichero "+fichero.isDirectory());
        System.out.println("Directorio "+directorio.isDirectory());

        System.out.println("");

        //Indica si son ficheros
        System.out.println("¿Son ficheros?: ");
        System.out.println("Fichero "+fichero.isFile());
        System.out.println("Directorio "+directorio.isFile());

        System.out.println("");

        //Indica la ruta absoluta del fichero o directorio
        System.out.println("Ruta absoluta: ");
        System.out.println("Fichero "+fichero.getAbsolutePath());
        System.out.println("Directorio "+directorio.getAbsolutePath());

        System.out.println("");

        //Indica si se puede leer
        System.out.println("¿Se pueden leer?:");
        System.out.println("Fichero "+fichero.canRead());
        System.out.println("Directorio "+directorio.canRead());

        System.out.println("");

        //Indica si se puede escribir
        System.out.println("¿Se pueden escribir?:");
        System.out.println("Fichero "+fichero.canWrite());
        System.out.println("Directorio "+directorio.canWrite());

        System.out.println("");

        //Indica si se puede ejecutar
        System.out.println("¿Se pueden ejecutar?:");
        System.out.println("Fichero "+fichero.canExecute());
        System.out.println("Directorio "+directorio.canExecute());

        System.out.println("");

        //Indica el nombre sin rutas
        System.out.println("Nombres sin rutas: ");
        System.out.println("Fichero "+fichero.getName());
        System.out.println("Directorio "+directorio.getName());

        System.out.println("");

        //Indica el nombre del directorio padre
        System.out.println("Nombre del directorio padre: ");
        System.out.println("Fichero "+fichero.getParent());
        System.out.println("Directorio "+directorio.getParent());

        System.out.println("");

        //Guarda en un array de File los directorios hijos, solo con directorios
        System.out.println("Nombre de los objetos File dentro de un array");
        File lista[]=directorio.listFiles();

        for (File f: lista){
            System.out.println(f);
        }

        System.out.println("");

        //Guarda en un array de String los directorios hijos, solo con directorios
        System.out.println("Nombre de los objetos String dentro de un array");
        String listaString[]=directorio.list();
        
        for (String s : listaString) {
            System.out.println(s);
        }

        System.out.println("");

        //Crea el directorio (no existe)
        System.out.println("Creando directorio...");
        System.out.println(directorio2.mkdir());

        System.out.println("");

        //Crea el fichero (no existe), debe controlarse la excepcion (arriba lanzamos la excepcion)
        System.out.println("Creando fichero...");
        System.out.println(fichero2.createNewFile());

        // Copiar ficheros y directorios JAVA NIO2
        //Files.copy(path, out)


        // borrar ficheros o directorios
        //fichero.delete();
        //directorio.delete();
        //Files.deleteIfExists(path)

        // Enlaces y otras operaciones en la clase Files
        //Files.createLink(path, path1)
        //Files.size();
        // Files.move();
        // Files, .... bla bla bla


    }
}
