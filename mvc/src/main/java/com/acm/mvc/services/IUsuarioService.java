package com.acm.mvc.services;

import com.acm.mvc.models.Usuario;

import java.util.Optional;

public interface IUsuarioService extends BaseService<Usuario> {
    Optional<Usuario> findByUsername(String username);
}
