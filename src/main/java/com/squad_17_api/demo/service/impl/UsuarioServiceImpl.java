package com.squad_17_api.demo.service.impl;

import com.squad_17_api.demo.exception.CursoExistenteException;
import com.squad_17_api.demo.exception.UsuarioExistenteException;
import com.squad_17_api.demo.model.Curso;
import com.squad_17_api.demo.model.Usuario;
import com.squad_17_api.demo.repository.UserRepository;
import com.squad_17_api.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Usuario> buscarTodos() {
        return userRepository.findAll();
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        return userRepository.findById(usuario.getEmail())
                .map(existingUsuario -> {
                    existingUsuario.setEmail(usuario.getEmail());
                    existingUsuario.setSenha(usuario.getSenha());
                    return userRepository.save(existingUsuario);
                })
                .orElseGet(() -> userRepository.save(usuario));
    }

    @Override
    public Usuario deletar(String email) {
        return userRepository.findById(email)
                .map(usuario -> {
                    userRepository.delete(usuario);
                    return usuario;
                })
                .orElse(null);
    }

}
