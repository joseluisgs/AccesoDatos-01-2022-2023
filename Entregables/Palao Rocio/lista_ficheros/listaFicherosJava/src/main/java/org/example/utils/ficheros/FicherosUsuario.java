package org.example.utils.ficheros;

import org.example.models.Usuario;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FicherosUsuario implements Ficheros<Usuario> {

    /**
     * Añadir usuarios a un fichero de texto.
     * @param lista lista de usuarios a añadir.
     * @param path ruta del fichero a escribir.
     */
    @Override
    public void addToFicheroText(List<Usuario> lista, String path) {
        File fichero;
        PrintWriter writer = null;
            try {
                fichero = new File(path);
                writer = new PrintWriter(new FileWriter(fichero,true));
                for (Usuario usuario : lista){
                    writer.println(usuario.toCsv());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally{
                if (writer != null){
                    writer.close();
                }
            }
    }


    /**
     * Leer un fichero de texto.
     * @param path ruta del fichero.
     * @return la lista de usuarios leídos.
     */
    @Override
    public List<Usuario> getFicheroText(String path) {
        List<Usuario> lista;
        try {
            lista = Files.lines(Path.of(path)).map(this::toUsuario).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }


    /**
     * Mapeo de objetos del tipo Usuario.
     * @param s linea a mapear.
     * @return el nuevo usuario.
     */
    private Usuario toUsuario(String s) {
        var campos = s.split(";");
        return new Usuario(UUID.fromString(campos[0]),campos[1],campos[2]);
    }


    /**
     * Escribir un fichero binario.
     * @param lista lista de usuario a escribir en binario.
     * @param path ruta del archivo.
     */
    @Override
    public void addToFicheroBinary(List<Usuario> lista, String path ) {
        File fichero;
        ObjectOutputStream output= null;
        try{
            fichero= new File(path);
            output = new ObjectOutputStream(new FileOutputStream(fichero));
            output.writeObject(lista);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    /**
     * Leer usuario de un fichero binario.
     * @param path ruta donde se encuentra el fichero.
     * @return la lista de usuarios.
     */
    @Override
    public List<Usuario> getFicheroBinary(String path) {
        List<Usuario> lista = null;
        File file;
        ObjectInputStream input = null;
        try{
            file = new File(path);
            input = new ObjectInputStream(new FileInputStream(file));

            lista = (List<Usuario>) input.readObject();

        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lista;
    }


    /**
     * Para crear el fichero si no existe y/o el directorio si tampoco existiese.
     * @param path ruta donde debe de estar el archivo.
     */
    @Override
    public void createIfNotExists(String path) {
        File file = new File(path);
        if (!file.exists() && Files.exists(Path.of(path))){
            try {
                file.createNewFile();
                System.out.println("Fichero creado");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }if (!file.exists() && !Files.exists(Path.of(path))){
            try {
                Files.createDirectories(Path.of(path));
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
