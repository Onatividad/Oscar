package com.practicando.service;

import com.practicando.model.Usuarios;
import com.practicando.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {
    private final UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public Usuarios guardarUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }
    public Usuarios findByEmailAndPassword(String email, String password) {
        return usuariosRepository.findByEmailAndPassword(email, password);
    }
}
