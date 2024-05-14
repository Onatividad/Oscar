package com.practicando.controller;

import com.practicando.model.Usuarios;
import com.practicando.service.UsuariosService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private UsuariosService usuariosService;

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		Usuarios usuario = usuariosService.findByEmailAndPassword(email, password);
		if (usuario != null) {
			session.setAttribute("usuario", usuario); // Almacenar el usuario en la sesión
			return "redirect:/";
		} else {
			model.addAttribute("error", "Credenciales incorrectas");
			return "login";
		}
	}

	@GetMapping("/flogin")
	public String mostrarLogin() {
		return "login";
	}
}
