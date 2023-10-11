package com.projeto.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LivrariaController {

    @GetMapping(value = "/")
    public String irParaHome() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String irParaLogin() {
        return "login";
    }

    @PostMapping(value = "/validar")
    public String validarLogin(@RequestParam String email, @RequestParam String senha) {

        System.out.println("Credenciais: " + email + " - " + senha);

        if (email.equalsIgnoreCase(senha)) {
            return "redirect:/";
        }
            return "redirect:/login";
    }

}
