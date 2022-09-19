package org.example.utils.ficheros;

import java.nio.file.Path;
import java.util.List;

interface Ficheros<T> {
    void addToFicheroText(List<T> lista, String path);
    List<T> getFicheroText(String path);
    void addToFicheroBinary(List<T> lista, String path);
    List<T> getFicheroBinary(String path);

    void createIfNotExists(String path);
}
