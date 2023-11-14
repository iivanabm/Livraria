package com.projeto.livraria.controller;

import com.projeto.livraria.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/cliente/lista")
    public String irParaTelaCliente(Model model) {

        model.addAttribute("listaDeClientes", clienteService.obterCliente());
        return "cliente/lista";
    }

    @GetMapping(value = "/cliente/{cpf}/excluir")
    public String excluirCliente(@PathVariable String cpf) {

        clienteService.excluir(cpf);

        return "redirect:/cliente/lista";
    }

}
