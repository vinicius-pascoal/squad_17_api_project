package com.squad_17_api.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad_17_api.demo.model.Aluno;
import com.squad_17_api.demo.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    public List<Aluno> buscarTodosAlunos() {
        return alunoRepository.findAll();
    }
    
    public Aluno buscarAlunoPorId(int id) {
        // Implemente a busca por ID aqui
        return null;
    }
    
    public Aluno atualizarAluno(Aluno aluno) {
        // Implemente a atualização do aluno aqui
        return null;
    }
    
    public void excluirAluno(int id) {
        // Implemente a exclusão do aluno aqui
    }
}
