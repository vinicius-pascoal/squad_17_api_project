package com.squad_17_api.demo.service;

import com.squad_17_api.demo.model.Curso;
import com.squad_17_api.demo.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> buscarTodos();
    Usuario buscarPorEmail(String email);
    Optional<Usuario> buscarPorId(Integer id);
    Usuario atualizar(Usuario usuario);
    Usuario deletar(String email);
    Usuario criar(Usuario usuario);
}
