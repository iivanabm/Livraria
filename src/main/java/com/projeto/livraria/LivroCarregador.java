package com.projeto.livraria;

import com.projeto.livraria.model.Livro;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Order(2)
@Component
public class LivroCarregador implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<Integer, Livro> livroMap = new HashMap<>();

        FileReader arquivo = new FileReader("Livro.txt");
        BufferedReader leitor = new BufferedReader(arquivo);

        String linha = leitor.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            Livro livro = new Livro(Integer.valueOf(campos[0]),
                    campos[1],
                    Float.parseFloat(campos[2]),
                    Boolean.valueOf(campos[3]),
                    campos[4],
                    campos[5]);

            livroMap.put(livro.getCodigo() ,livro);

            linha = leitor.readLine();
        }

        for (Livro livro : livroMap.values()) {
            System.out.println("[Livro] Inclusão no carrinho: " + livro);
        }

        leitor.close();

    }
}
