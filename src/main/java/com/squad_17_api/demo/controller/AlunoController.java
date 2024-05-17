package com.squad_17_api.demo.controller;

import com.squad_17_api.demo.model.Aluno;
import com.squad_17_api.demo.model.Curso;
import com.squad_17_api.demo.service.*;
import com.squad_17_api.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private CursoService cursoService;
    
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
        if (aluno.getId() != null && alunoRepository.existsById(aluno.getId())) {
            throw new IllegalArgumentException("Não é possível adicionar o aluno porque já existe um aluno com o ID fornecido.");
        }

        Aluno novoAluno = alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable int id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable int id, @RequestBody Aluno alunoAtualizado) {
        if (!alunoRepository.existsById(id)) {
            throw new IllegalArgumentException("Não é possível atualizar o aluno porque não existe nenhum aluno com o ID fornecido.");
        }

        alunoAtualizado.setId(id); // Garante que o ID seja o mesmo

        Aluno aluno = alunoRepository.save(alunoAtualizado);
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable int id) {
        if (!alunoRepository.existsById(id)) {
            throw new IllegalArgumentException("Aluno não encontrado");
        }

        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
