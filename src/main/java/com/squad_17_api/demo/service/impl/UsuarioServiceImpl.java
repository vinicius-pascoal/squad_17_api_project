package com.squad_17_api.demo.service.impl;

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
}
