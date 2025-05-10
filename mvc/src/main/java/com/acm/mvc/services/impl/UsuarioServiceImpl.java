package com.acm.mvc.services.impl;

import com.acm.mvc.models.Usuario;
import com.acm.mvc.persistence.entity.UsuarioEntity;
import com.acm.mvc.persistence.repository.UsuarioRepository;
import com.acm.mvc.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity user = usuarioRepository.save(new UsuarioEntity(usuario.getId(),usuario.getUsername(),usuario.getPassword()));
        return Usuario.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    @Override
    public Usuario update(Usuario usuario) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll().stream().map(userE -> Usuario.builder()
                .id(userE.getId())
                .username(userE.getUsername())
                .build()).collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        for (UsuarioEntity usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return Optional.of(Usuario
                        .builder()
                                .id(usuario.getId())
                                .password(usuario.getPassword())
                                .username(usuario.getUsername())
                        .build());
            }
        }
        return Optional.empty();
    }
}