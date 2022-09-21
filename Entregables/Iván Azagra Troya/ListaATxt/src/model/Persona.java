package model;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Persona {
    private UUID id = randomUUID();
    private String user;
    private String email;

    private Persona() {}

    public Persona(String user, String email) {
        this.user = user;
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
