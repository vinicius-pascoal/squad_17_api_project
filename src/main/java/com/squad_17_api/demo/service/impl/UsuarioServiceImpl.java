package com.squad_17_api.demo.service.impl;

import com.squad_17_api.demo.exception.CursoExistenteException;
import com.squad_17_api.demo.exception.UsuarioExistenteException;
import com.squad_17_api.demo.model.Usuario;
import com.squad_17_api.demo.repository.UserRepository;
import com.squad_17_api.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.persistence.Id;
import java.awt.font.OpenType;

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
    public Optional<Usuario> buscarPorId(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public Usuario deletar(String email) {
        Usuario usuario = userRepository.findByEmail(email);
        if (usuario != null) {
            userRepository.delete(usuario);
        }
        return usuario;


    }

    @Override
    public Usuario criar(Usuario usuario) {
        if (userRepository.findById(usuario.getId()).isPresent()) {
            throw new UsuarioExistenteException("Já existe um usuário com o ID informado. Utilize o método atualizar para modificar um usuário existente.");
        }
        return userRepository.save(usuario);
    }
}
