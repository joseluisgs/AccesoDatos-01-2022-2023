import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path file = Paths.get("src"+File.separator+"partida"+ File.separator+"Fichero");
        File directorio = new File("src"+File.separator+"Destiny");
        Path destiny = Paths.get(directorio+File.separator+"Fichero");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige la opcion: ");
        System.out.println("--- Copiar ---");
        System.out.println("--- Mover ---");
        String eleccion = scanner.next();

        try {
            if (!directorio.exists()) {
                directorio.mkdirs();
            }
            if (Files.exists(file)) {
                if (eleccion.equalsIgnoreCase("Copiar")) {
                    Files.copy(file, destiny, StandardCopyOption.REPLACE_EXISTING);
                }else if (eleccion.equalsIgnoreCase("Mover")) {
                    Files.move(file, destiny, StandardCopyOption.REPLACE_EXISTING);
                }else {
                    System.out.println("Esta opcion no existe");
                }
            } else {
                System.out.println("No se encuentra este fichero");
            }
            System.out.println("Proceso terminado con exito");
        }catch(IOException e) {
            System.out.println("Ha ocurrido el error: "+e.getMessage());
            e.printStackTrace();
        }
    }
}