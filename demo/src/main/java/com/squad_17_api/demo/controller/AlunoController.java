package com.squad_17_api.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.squad_17_api.demo.model.Aluno; // Importação da classe Aluno
import com.squad_17_api.demo.service.AlunoService;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;
    
    // Endpoint para criar um novo aluno
    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }
    
    // Endpoint para buscar todos os alunos
    @GetMapping
    public List<Aluno> buscarAlunos() {
        return alunoService.buscarTodosAlunos();
    }
    
    // Endpoint para buscar um aluno por ID
    @GetMapping("/{id}")
    public Aluno buscarAlunoPorId(@PathVariable int id) {
        return alunoService.buscarAlunoPorId(id);
    }
    
    // Endpoint para atualizar um aluno existente
    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable int id, @RequestBody Aluno aluno) {
        aluno.setId_aluno(id); // Garantir que o ID do aluno está definido corretamente
        return alunoService.atualizarAluno(aluno);
    }
    
    // Endpoint para excluir um aluno
    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable int id) {
        alunoService.excluirAluno(id);
    }
}
