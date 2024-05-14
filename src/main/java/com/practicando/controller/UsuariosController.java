package com.practicando.controller;

import com.practicando.model.Usuarios;
import com.practicando.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuariosController {

	private final UsuariosService usuariosService;

	@Autowired
	public UsuariosController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}

	@GetMapping("/registro")
	public String mostrarFormularioRegistro(Model model) {
		model.addAttribute("usuario", new Usuarios());
		return "usuario/registro";
	}

	@PostMapping("/registro")
	public String registrarUsuario(@ModelAttribute("usuario") Usuarios usuario) {
		usuariosService.guardarUsuario(usuario);
		return "redirect:/registro-exitoso";
	}

	@GetMapping("/registro-exitoso")
	public String registroExitoso() {
		return "usuario/registro-exitoso";
	}
}
