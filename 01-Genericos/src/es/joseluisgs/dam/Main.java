package es.joseluisgs.dam;

import es.joseluisgs.dam.tdas.Cola;

import javax.sound.midi.Instrument;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("GENERICOS");

        Persona p1 = new Persona(20, "Pepe");
        Persona p2 = new Persona(18, "Ana");
        Persona p3 = new Persona(25, "Luis");
        Persona p4 = new Persona(30, "Vives");

        Cola<Persona> cola = new Cola<>();
        cola.encolar(p1);
        cola.encolar(p2);
        cola.encolar(p3);
        cola.encolar(p4);

        for (Persona p: cola) {
            System.out.println(p);
        }

        System.out.println("COMPARABLE");
        List<Persona> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);

        Collections.sort(lista);
        for (Persona p: lista) {
            System.out.println(p);
        }

        System.out.println("COMPARATOR");
        PersonaNombreComparator pComparator = new PersonaNombreComparator();
        Collections.sort(lista, pComparator);

        for (Persona p: lista) {
            System.out.println(p);
        }

        // Con Funcional
        System.out.println("COMPARATOR2");
        Comparator<Persona> viejuno = (v1, v2) -> Integer.compare(v2.edad, v1.edad);
        Collections.sort(lista, viejuno);

        for (Persona p: lista) {
            System.out.println(p);
        }

        Instrumento i1 = new Instrumento("cuerda", "guitarra", 45);
        Instrumento i2 = new Instrumento("percusion", "bateria", 96);
        Instrumento i3 = new Instrumento("cuerda", "guitarra", 45);

        ArrayList<Instrumento> array = new ArrayList<>();
        array.add(i1);
        array.add(i2);
        for (Instrumento i: array) {
            System.out.println(i.toString());
        }

        TreeSet<Instrumento> set = new TreeSet<>();
        set.add(i1);
        set.add(i2);
        set.add(i3);

        for (Instrumento i: set) {
            System.out.println(i.toString());
        }

        HashSet<Instrumento> hash = new HashSet<>();
        hash.add(i1);
        hash.add(i2);
        hash.add(i3);

        for (Instrumento i: hash) {
            System.out.println(i.toString());
        }

        TreeMap<Integer, Instrumento> map = new TreeMap<>();
        map.put(1, i1);
        map.put(2, i2);
        map.put(2, i3);

        System.out.println(map.get(2));





    }
}
