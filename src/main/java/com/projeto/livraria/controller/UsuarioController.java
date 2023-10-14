package com.projeto.livraria.controller;

import com.projeto.livraria.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SessionAttributes("usuario")
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

    @GetMapping(value = "/usuario/cadastro")
    public String irParaTelaCadastro() {

        return "usuario/cadastro";
    }

    public Usuario validar(String email, String senha) {
        Usuario usuario = usuarioMap.get(email);

        if (!Objects.isNull(usuario) && senha.equalsIgnoreCase(usuario.getSenha())) {
            return usuario;
        }

        return null;
    }

    @PostMapping(value = "/validar")
    public String validarLogin(Model model, @RequestParam String email, @RequestParam String senha) {

        Usuario usuario = validar(email, senha);

        if (!Objects.isNull(usuario)) {
            model.addAttribute("usuario", usuario);

            return "home";
        }
        return "redirect:/login";
    }

}
