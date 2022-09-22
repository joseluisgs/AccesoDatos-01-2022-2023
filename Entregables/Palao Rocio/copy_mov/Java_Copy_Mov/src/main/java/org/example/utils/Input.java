package org.example.utils;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Input {
    private final Scanner scanner = new Scanner(System.in);


    /**
     * Pedir el comando necesario.
     * @return el comando.
     */
    public String getStringPath(){
    String entrada;
        do {
            System.out.println("Escribe el comando para copiar o mover un archivo \n" +
                    "cp/mv rutaArchivo nuevaRuta");
            entrada = scanner.nextLine();
        }while(!rutaCorrecta(entrada));
       return entrada;
    }


    /**
     * Ver si la ruta inicial es correcta y si se ha escrito bien el comando cp/mv.
     * @param line entrada de datos.
     * @return si es correcto o no.
     */
    private boolean rutaCorrecta(String line) {
        var comando = line.split(" ");
        if(comando[0].equals("cp") || comando[0].equals("mv")){
            return Files.exists(Path.of(comando[1]).toAbsolutePath());
        }else{
            System.out.println("Comando no reconocido");
        }
      return false;
    }


    /**
     * Preguntar si se desea sobreescribir el archivo.
     * @return boolean dependiendo de la elección.
     */
    public boolean sobreescribirArchivo(){
        var line="";
        do{
            System.out.println("Desea sobreescribir el archivo?   si/no");
            line = scanner.nextLine();
        }while (!line.equalsIgnoreCase("si") && !line.equalsIgnoreCase("no"));
        return line.equalsIgnoreCase("si");
    }
}
