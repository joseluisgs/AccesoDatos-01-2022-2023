package es.joseluisgs.dam;

import java.util.Objects;

public class Instrumento  implements Comparable<Instrumento> {
    String tipo;
    String nombre;
    int valor;

    public Instrumento(String tipo, String nombre, int valor) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Instrumento{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrumento that = (Instrumento) o;
        return valor == that.valor && Objects.equals(tipo, that.tipo) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, nombre, valor);
    }

    @Override
    public int compareTo(Instrumento o) {
       if(valor == o.valor) {
           return 0;
       } else if(valor < o.valor) {
           return 1;
       } else if(valor > o.valor) {
           return -1;
       }
       return 0;
    }
}
