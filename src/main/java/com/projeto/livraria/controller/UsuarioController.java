package com.projeto.livraria.controller;

import com.projeto.livraria.model.Usuario;
import com.projeto.livraria.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

//@SessionAttributes("usuario")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/validar")
    public String validarLogin(Model model, @RequestParam String email, @RequestParam String senha) {

        Usuario usuario = usuarioService.validar(email, senha);

        if (!Objects.isNull(usuario)) {
            model.addAttribute("usuario", usuario);

            return "home";
        }
        return "redirect:/login";
    }
    @GetMapping(value = "/usuario/lista")
    public String irParaTelaCliente(Model model) {

        model.addAttribute("listaDeUsuarios", usuarioService.obterUsuarios());
        return "usuario/lista";
    }

    @GetMapping(value = "/usuario/{email}/excluir")
    public String excluirCliente(@PathVariable String email) {

        usuarioService.excluir(email);

        return "redirect:/usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluirUsuario(Usuario usuario) {
        usuarioService.incluir(usuario);
        return "redirect:/";
    }

    @GetMapping(value = "/usuario/cadastro")
    public String irParaTelaCadastro() {

        return "usuario/cadastro";
    }
}
