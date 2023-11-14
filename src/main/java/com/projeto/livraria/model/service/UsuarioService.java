package com.projeto.livraria.model.service;

import com.projeto.livraria.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UsuarioService {

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

    public Usuario validar(String email, String senha) {
        Usuario usuario = usuarioMap.get(email);

        if (!Objects.isNull(usuario) && senha.equalsIgnoreCase(usuario.getSenha())) {
            return usuario;
        }

        return null;
    }
}
