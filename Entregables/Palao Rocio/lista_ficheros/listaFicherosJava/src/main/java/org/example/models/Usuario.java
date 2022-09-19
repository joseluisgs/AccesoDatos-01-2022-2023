package org.example.models;

import java.io.Serializable;
import java.util.UUID;

public class Usuario implements Serializable {
    UUID id;
    String nombre;
    String email;

    public Usuario(UUID id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String toCsv(){
        return id+";"+nombre+";"+email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
