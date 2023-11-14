package com.projeto.livraria.model.service;

import com.projeto.livraria.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

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
}
