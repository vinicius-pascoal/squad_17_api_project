package com.squad_17_api.demo.service;

import com.squad_17_api.demo.model.Aluno;
import com.squad_17_api.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> obterAlunoPorId(int id) {
        return alunoRepository.findById(id);
    }

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(int id, Aluno alunoAtualizado) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado: " + id);
        }
        alunoAtualizado.setAluno_id(id);
        return alunoRepository.save(alunoAtualizado);
    }

    public void deletarAluno(int id) {
        alunoRepository.deleteById(id);
    }
}
