package com.practicando.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practicando.model.Productos;
import com.practicando.service.ProductosService;

@Controller
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping("/")
    public String home(Model model, Pageable pageable) {
        pageable = PageRequest.of(0, 6); // Página inicial con 10 productos
        Page<Productos> productosPage = productosService.findAll(pageable);
        model.addAttribute("productos", productosPage.getContent());
        model.addAttribute("paginaActual", productosPage.getNumber());
        model.addAttribute("totalPaginas", productosPage.getTotalPages());
        return "home";
    }

    @GetMapping("/pagina/{pagina}")
    public String pagina(Model model, @PathVariable("pagina") int pagina) {
        Pageable pageable = PageRequest.of(pagina, 6);
        Page<Productos> productosPage = productosService.findAll(pageable);
        model.addAttribute("productos", productosPage.getContent());
        model.addAttribute("paginaActual", productosPage.getNumber());
        model.addAttribute("totalPaginas", productosPage.getTotalPages());
        return "home";
    }
}
