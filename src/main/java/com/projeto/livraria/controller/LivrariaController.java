package com.projeto.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

}
