package com.projeto.livraria.controller;

import com.projeto.livraria.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UsuarioController {

    private Map<String, Usuario> usuarioMap = new HashMap<>();

    public Collection<Usuario> obterUsuarios() {
        return usuarioMap.values();
    }

    public void incluir(Usuario usuario) {
        usuarioMap.put(usuario.getEmail(), usuario);
        System.out.println("[Usuário] Inclusão do usuario: " + usuario);
    }

    public void excluir(String email) {
        usuarioMap.remove(email);
    }

    @GetMapping(value = "/usuario/lista")
    public String irParaTelaCliente(Model model) {

        model.addAttribute("listaDeUsuarios", obterUsuarios());
        return "usuario/lista";
    }

    @GetMapping(value = "/usuario/{email}/excluir")
    public String excluirCliente(@PathVariable String email) {

        excluir(email);

        return "redirect:/usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluirUsuario(Usuario usuario) {
        incluir(usuario);
        return "redirect:/";
    }

}
