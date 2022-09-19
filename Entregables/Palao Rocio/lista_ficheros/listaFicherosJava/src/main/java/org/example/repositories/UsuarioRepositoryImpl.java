package org.example.repositories;


import org.example.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UsuarioRepositoryImpl extends ArrayList<Usuario> implements UsuarioRepository  {
    @Override
    public void addFirstData() {
        this.add(new Usuario(UUID.randomUUID(),"Paco","paco@gmail.com"));
        this.add(new Usuario(UUID.randomUUID(),"Carmen","cfz@hotmail.com"));
        this.add(new Usuario(UUID.randomUUID(),"Luisa","lu1s4@gmail.com"));
    }

    @Override
    public List<Usuario> getData() {
        return this;
    }
}
