package com.projeto.livraria.model.service;

import com.projeto.livraria.model.Cliente;
import com.projeto.livraria.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Collection<Cliente> obterCliente() {
        return (Collection<Cliente>) clienteRepository.findAll();
    }

    public void incluir(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void excluir(String cpf) {
        clienteRepository.deleteById(cpf);
    }
}
