package es.joseluisgs.dam;

public class Persona implements Comparable<Persona> {
    int edad;
    String nombre;

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public int compareTo(Persona o) {
//        if(this.edad == o.edad)
//            return 0;
//        else if(this.edad>o.edad)
//            return 1;
//        else
//            return -1;
        return Integer.compare(edad,o.edad);
    }
}

