package com.projeto.livraria;

import com.projeto.livraria.controller.ClienteController;
import com.projeto.livraria.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class ClienteCarregador implements ApplicationRunner {

    private Map<String, Cliente> clienteMap = new HashMap<>();

    public Collection<Cliente> obterCliente() {
        return clienteMap.values();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        clienteMap = new HashMap<>();

        FileReader arquivo = new FileReader("cliente.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Cliente cliente = new Cliente(
                campos[0],
                campos[1],
                campos[2]
            );

            clienteMap.put(cliente.getCpf(), cliente);
            linha = leitor.readLine();
        }

        for (Cliente cliente : clienteMap.values()) {
            System.out.println("[Cliente] Inclusão do cliente: " + cliente);
        }

        leitor.close();
    }
}
