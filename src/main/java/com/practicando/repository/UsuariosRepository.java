package com.practicando.repository;

import com.practicando.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
	Usuarios findByEmailAndPassword(String email, String password);

}
