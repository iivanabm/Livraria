package com.projeto.livraria;

import com.projeto.livraria.model.Caderno;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Order(3)
@Component
public class CadernoCarregador implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<Integer, Caderno> cadernoMap = new HashMap<>();

        FileReader arquivo = new FileReader("Caderno.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

                Caderno caderno = new Caderno(Integer.valueOf(campos[0]),
                    campos[1],
                    Float.parseFloat(campos[2]),
                    campos[3],
                    Boolean.parseBoolean(campos[4]),
                    campos[5]);

            cadernoMap.put(caderno.getCodigo(), caderno);

            linha = leitor.readLine();
        }

        for (Caderno caderno : cadernoMap.values()) {
            System.out.println("[Caderno] Inclusão no carrinho: " + caderno);
        }

        leitor.close();

    }
}
