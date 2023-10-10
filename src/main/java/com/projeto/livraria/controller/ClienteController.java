package com.projeto.livraria.controller;

import com.projeto.livraria.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClienteController {

    private Map<String, Cliente> clienteMap = new HashMap<>();

    public Collection<Cliente> obterCliente() {
        return clienteMap.values();
    }

    public void incluir(Cliente cliente) {
        clienteMap.put(cliente.getCpf(), cliente);
        System.out.println("[Cliente] Inclusão do cliente: " + cliente);
    }

    public void excluir(String cpf) {
        clienteMap.remove(cpf);
    }

    @GetMapping(value = "/cliente/lista")
    public String irParaTelaCliente(Model model) {

        model.addAttribute("listaDeClientes", obterCliente());
        return "cliente/lista";
    }

    @GetMapping(value = "/cliente/{cpf}/excluir")
    public String excluirCliente(@PathVariable String cpf) {

        excluir(cpf);

        return "redirect:/cliente/lista";
    }

}
