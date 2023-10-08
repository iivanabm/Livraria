package com.projeto.livraria;

import com.projeto.livraria.model.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.*;

@Order(1)
@Component
public class CompraCarregador implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<LocalDateTime, Compra> compraMap = new HashMap<>();

        FileReader arquivo = new FileReader("Compra.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();

        String[] campos = null;

        Compra compra = null;

        while (linha != null) {
            campos = linha.split(";");

            switch (campos[0]) {
                case "C":

                    compra = new Compra(
                            campos[1],
                            new Cliente(campos[2], campos[3], campos[4]),
                            new ArrayList<Produto>()
                    );

                    compraMap.put(compra.getData(), compra);

                    break;

                case "L":
                    Livro livro = new Livro(
                            Integer.valueOf(campos[1].trim()),
                            campos[2],
                            Float.parseFloat(campos[3]),
                            Boolean.valueOf(campos[4]),
                            campos[5],
                            campos[6]
                    );

                    if (!Objects.isNull(compra)) {
                        compra.getProdutos().add(livro);
                    }

                    break;

                case "M":
                    Mochila mochila = new Mochila(
                            Integer.parseInt(campos[1].trim()),
                            campos[2],
                            Float.parseFloat(campos[3]),
                            campos[4],
                            campos[5],
                            Boolean.parseBoolean(campos[6])
                    );

                    if (!Objects.isNull(compra)) {
                        compra.getProdutos().add(mochila);
                    }
                    break;

                case "CA":
                    Caderno caderno = new Caderno(
                            Integer.valueOf(campos[1].trim()),
                            campos[2],
                            Float.parseFloat(campos[3]),
                            campos[4],
                            Boolean.parseBoolean(campos[5]),
                            campos[6]
                    );

                    if (!Objects.isNull(compra)) {
                        compra.getProdutos().add(caderno);
                    }
                    break;

                default:
                    break;
            }

            linha = leitor.readLine();
        }

        for (Compra cadaCompra : compraMap.values()) {
            System.out.println("[Compra] Inclusão no carrinho: " + cadaCompra);
        }

        leitor.close();

    }
}
