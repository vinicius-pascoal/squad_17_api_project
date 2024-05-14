package com.squad_17_api.demo.service.impl;

import com.squad_17_api.demo.model.Aluno;
import main.java.com.squad_17_api.demo.service.AlunoService;
import com.squad_17_api.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }
}
