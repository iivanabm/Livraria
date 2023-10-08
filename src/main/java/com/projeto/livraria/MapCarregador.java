package com.projeto.livraria;

import com.projeto.livraria.model.Cliente;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MapCarregador implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Cliente cliente = new Cliente("Ana Maria", "123456789101", "ana.maria@gmail.com");
        Cliente cliente2 = new Cliente("João José", "35687412036", "josejoao@gmail.com");
        Cliente cliente3 = new Cliente("Maria Maria", "15789635412", "m.maria@gmail.com");

        Map<String, Cliente> clienteMap = new HashMap<>();
        clienteMap.put("123456789101", cliente);
        clienteMap.put("35687412036", cliente2);
        clienteMap.put("15789635412", cliente3);

        System.out.println("keyset: " + clienteMap.keySet());
        System.out.println("values: " + clienteMap.values());
        System.out.println("get: " + clienteMap.get("123456789101"));

        clienteMap.remove("15789635412");
        System.out.println("get: " + clienteMap.get("15789635412"));


    }
}
