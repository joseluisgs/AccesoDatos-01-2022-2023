package es.joseluisgs.dam;

import java.util.Comparator;

public class PersonaNombreComparator implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        return p1.nombre.compareToIgnoreCase(p2.nombre);
    }
}
