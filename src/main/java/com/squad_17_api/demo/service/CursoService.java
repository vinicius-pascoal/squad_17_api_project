package com.squad_17_api.demo.service;

import com.squad_17_api.demo.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> buscarTodos();
    Optional<Curso> buscarPorId(Integer id);
    Curso criar(Curso curso);
    Curso atualizar(Curso curso);
    Curso deletar(Integer id);

}
