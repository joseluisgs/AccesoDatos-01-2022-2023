package es.joseluisgs.dam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    // Devuelve todas las rutas de un directorio dado
        try (Stream<Path> stream = Files.list(Paths.get(System.getProperty("user.home")))) {
            stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Devuelve todas las rutas a partir de un
//        directorio dado que cumplen una
//        condición. Se le puede indicar una
//        profundidad máxima.
        Path start = Paths.get(System.getProperty("user.home"));
        int maxDepth = 5;
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, attr) ->  String.valueOf(path).endsWith(".txt"))) {
            stream
                    .sorted()
                    .map(String::valueOf)
                    .forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //Devuelve todas las rutas a partir de un
//        directorio dado. Se le puede indicar una
//        profundidad máxima.

        start = Paths.get(System.getProperty("user.home"));
        maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            TreeMap<String, Long> groupByExtension =
                    stream
                            .filter(Files::isRegularFile)
                            .sorted()
                            .collect(Collectors.groupingBy(Main::getExtension, TreeMap::new, Collectors.counting()));

            groupByExtension.forEach((k, v) -> System.out.printf("%s -> %d ficheros%n", k, v));


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static String getExtension(Path p) {
        String extension = "";
        String fileName = p.getFileName().toString();

        int i = fileName.lastIndexOf('.');
        if (i >= 0) {
            extension = fileName.substring(i);
        }
        return extension;
    }

}
