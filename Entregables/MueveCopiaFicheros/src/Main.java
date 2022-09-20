import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path file = Paths.get("src/partida/Fichero");
        Path destiny = Paths.get("src/destiny/Fichero");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige la opcion: ");
        System.out.println("--- Copiar ---");
        System.out.println("--- Pegar ---");
        String eleccion = scanner.next();

        try {
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