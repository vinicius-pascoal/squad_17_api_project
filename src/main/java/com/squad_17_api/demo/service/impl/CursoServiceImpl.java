package com.squad_17_api.demo.service.impl;

import com.squad_17_api.demo.model.Curso;
import com.squad_17_api.demo.repository.CursoRepository;
import com.squad_17_api.demo.service.CursoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.OpenType;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> buscarTodos() {
       return cursoRepository.findAll();

    }
    @Override
    public Optional<Curso> buscarPorId(Integer id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso criar(Curso curso) {
        return cursoRepository.save(curso);
    }

}
