package com.practicando.controller;

import com.practicando.model.Usuario;
import com.practicando.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/list")
    public String listUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.getAllUsuarios());
        return "usuario/list";
    }

    @GetMapping("/form")
    public String showUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/form";
    }

    @GetMapping("/form/{id}")
    public String showEditUsuarioForm(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario inválido ID:" + id));
        model.addAttribute("usuario", usuario);
        return "usuario/form";
    }

    @PostMapping("/form")
    public String saveOrUpdateUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.saveOrUpdateUsuario(usuario);
        return "redirect:/usuarios/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable("id") Long id) {
        usuarioService.deleteUsuario(id);
        return "redirect:/usuarios/list";
    }
}
