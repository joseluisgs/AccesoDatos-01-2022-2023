import models.Persona;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static File directorio = new File(System.getProperty("user.dir") + File.separator + "registro");
    static File registro = new File(directorio + File.separator + "usuarios");
    static Scanner scanner = new Scanner(System.in);
    static List<Persona> usuarios = new ArrayList<>();
    static ObjectOutputStream f = null;

    public static void main(String[] args) {

        usuarios.add(new Persona("Maria", "email@email.com"));
        usuarios.add(new Persona("Pedro", "email2@email.com"));
        usuarios.add(new Persona("Pablo", "email3@email.com"));

        System.out.println("Quiere añadir o sobrescribir?");
        String respuesta = scanner.next();
        try {
            if(!registro.exists()) {
                directorio.mkdirs();
                registro.createNewFile();

                if(respuesta.equalsIgnoreCase("Añadir")){
                    escribirFichero();
                }else if(respuesta.equalsIgnoreCase("Sobrescribir")){
                    sobrescribir();
                }
            }

        }catch(IOException e) {
            System.out.println("Ha ocurrido el error: "+e.getMessage());
        }finally {
            try {
                if( f != null) {
                    f.close();
                }
            }catch(IOException e) {
                System.out.println("Error en finally: "+e.getMessage());
            }
        }
    }

    public static void escribirFichero() throws IOException {
        f = new ObjectOutputStream(new FileOutputStream(registro, true));
        for(Persona p : usuarios) {
            f.writeObject(p);
        }
        System.out.println("Se han guardado los datos");
    }

    public static void sobrescribir() throws IOException {
        f = new ObjectOutputStream(new FileOutputStream(registro, false));
        for(Persona p : usuarios) {
            f.writeObject(p);
        }
    }
}