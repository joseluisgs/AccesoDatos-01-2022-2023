import model.Persona;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static File directorio = new File(System.getProperty("user.dir")+File.separator+"registro");
    static File registro = new File(directorio+File.separator+"usuarios.txt");
    static Scanner scanner = new Scanner(System.in);
    static List<Persona> usuarios = new ArrayList<>();
    static PrintWriter f = null;
    public static void main(String[] args) {

        usuarios.add(new Persona("Maria", "email@email.com"));
        usuarios.add(new Persona("Pedro", "email2@email.com"));
        usuarios.add(new Persona("Pablo", "email3@email.com"));

        try {
            if(!registro.exists()) {
                creaDirectorios();
            }else {
                manejaFichero();
            }
        }catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (f != null) {
                f.close();
            }
        }
    }

    public static void creaDirectorios() throws IOException {
        directorio.mkdirs();
        registro.createNewFile();

        if(registro.exists()) {
            manejaFichero();
        }
    }

    public static void manejaFichero() throws IOException {
        System.out.println("Ya existe el archivo de registro, desea añadir o sobrescribir contenido?");
        System.out.println("Elija añadir o sobrescribir");
        String respuesta = scanner.next();
        if(respuesta.equalsIgnoreCase("añadir")) {
            f = new PrintWriter(new FileWriter(registro, true));
            for(Persona p : usuarios) {
                f.println("Usuario: "+p.toString());
            }
            System.out.println("Se ha añadido el contenido al fichero");
        }else if(respuesta.equalsIgnoreCase("sobrescribir")) {
            f = new PrintWriter(new FileWriter(registro, false));
            for(Persona p : usuarios) {
                f.println("Usuario sobrescrito: "+p.toString());
            }
            System.out.println("Se ha sobrescrito el contenido del fichero");
        }else {
            System.out.println("Esa opción no es válida");
        }
    }
}