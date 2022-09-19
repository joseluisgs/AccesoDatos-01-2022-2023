package es.joseluisgs.dam.utils;

import es.joseluisgs.dam.model.Product;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Util {

    public static List<Product> getProducts() throws IOException {
        // Cargamos el archivo ubicado en la carpeta data
        String DATA_FILE = "products.csv";
        String WORKING_DIRECTORY = System.getProperty("user.dir");
        Path path = Paths.get(WORKING_DIRECTORY + File.separator + "data" + File.separator + DATA_FILE);
        final List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        // lines.forEach(System.out::println);
        List<Product> products = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            // System.out.println("Proceso la linea: " + (i-1));
            StringTokenizer tokenizer = new StringTokenizer(lines.get(i), ",");
            Product product = new Product();
            product.setId(Integer.parseInt(tokenizer.nextToken()));
            product.setName(tokenizer.nextToken());
            product.setSupplier(Integer.parseInt(tokenizer.nextToken()));
            product.setCategory(Integer.parseInt(tokenizer.nextToken()));
            tokenizer.nextToken(); //saltamos la columna quantityPerUnit
            product.setUnitPrice(Double.parseDouble(tokenizer.nextToken()));
            product.setUnitsInStock(Integer.parseInt(tokenizer.nextToken()));
            // System.out.println(product.toString());
            products.add(product);
        }// products.forEach(System.out::println);
        return products;
    }
}
