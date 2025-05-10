package com.acm.mvc.persistence.repository;

import com.acm.mvc.persistence.entity.UsuarioEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {
    private static final List<UsuarioEntity> usuarios = new ArrayList<>();
    // Simulando una base de datos en memoria
    static{
        usuarios.add(new UsuarioEntity(1L, "admin", "admin"));
        usuarios.add(new UsuarioEntity(2L, "user", "user"));
        usuarios.add(new UsuarioEntity(3L, "guest", "guest"));
        usuarios.add(new UsuarioEntity(4L, "root", "root"));
    }

    public UsuarioEntity save(UsuarioEntity usuario){
        usuarios.add(usuario);
        return usuarios.get(usuarios.indexOf(usuario));
    }
    public UsuarioEntity update(UsuarioEntity t){
        if (!usuarios.contains(usuarios)){
            throw new IllegalArgumentException("Usuario no encontrado");
        }else{
            usuarios.remove(t);
            usuarios.add(t);
        }
        return usuarios.get(usuarios.indexOf(t));
    }
    public void delete(Long id){
        UsuarioEntity usuario = findById(id);
        if (usuario == null){
            throw new IllegalArgumentException("Usuario no encontrado");
        }else{
            usuarios.remove(usuario);
        }
    }
    public UsuarioEntity findById(Long id){
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<UsuarioEntity> findAll(){
        return usuarios;
    }

}
