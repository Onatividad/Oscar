package com.practicando.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practicando.model.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
    Page<Productos> findAll(Pageable pageable);
}
