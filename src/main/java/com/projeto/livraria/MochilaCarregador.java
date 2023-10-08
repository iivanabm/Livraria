package com.projeto.livraria;

import com.projeto.livraria.model.Mochila;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Order(4)
@Component
public class MochilaCarregador implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<Integer, Mochila> mochilaMap = new HashMap<>();

        FileReader arquivo = new FileReader("Mochila.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Mochila mochila = new Mochila(Integer.valueOf(campos[0]),
                    campos[1],
                    Float.parseFloat(campos[2]),
                    campos[3],
                    campos[4],
                    Boolean.parseBoolean(campos[5]));

            mochilaMap.put(mochila.getCodigo(), mochila);

            linha = leitor.readLine();
        }

        for (Mochila mochila : mochilaMap.values()) {
            System.out.println("[Mochila] Inclusão no carrinho: " + mochila);
        }

        leitor.close();

    }
}
