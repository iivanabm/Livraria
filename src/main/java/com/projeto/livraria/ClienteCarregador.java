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

@Component
public class ClienteCarregador implements ApplicationRunner {

    @Autowired
    private ClienteController clienteController;

    @Override
    public void run(ApplicationArguments args) throws Exception {

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

            clienteController.incluir(cliente);

            linha = leitor.readLine();
        }

        leitor.close();
    }
}
