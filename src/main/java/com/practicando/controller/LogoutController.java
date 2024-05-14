package com.practicando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("usuario"); // Eliminar el usuario de la sesión
        return "redirect:/";
    }
}

