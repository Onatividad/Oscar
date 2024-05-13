package com.practicando.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.practicando.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
