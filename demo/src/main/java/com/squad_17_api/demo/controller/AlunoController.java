package com.squad_17_api.demo.controller;

import com.squad_17_api.demo.model.Aluno;
import com.squad_17_api.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @GetMapping("/{id}")
    public Aluno obterAlunoPorId(@PathVariable int id) {
        return alunoService.obterAlunoPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado: " + id));
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.criarAluno(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable int id, @RequestBody Aluno alunoAtualizado) {
        return alunoService.atualizarAluno(id, alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable int id) {
        alunoService.deletarAluno(id);
    }
}
