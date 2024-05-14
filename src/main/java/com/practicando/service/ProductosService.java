package com.practicando.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.practicando.model.Productos;
import com.practicando.repository.ProductosRepository;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public Page<Productos> findAll(Pageable pageable) {
        return productosRepository.findAll(pageable);
    }
}
