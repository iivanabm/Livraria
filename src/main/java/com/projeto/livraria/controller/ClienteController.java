package com.projeto.livraria.controller;

import com.projeto.livraria.ClienteCarregador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteCarregador clienteCarregador;

    @GetMapping(value = "/cliente/lista")
    public String irParaTelaCliente(Model model) {

        model.addAttribute("listaDeClientes", clienteCarregador.obterCliente());
        return "cliente/lista";
    }

}
