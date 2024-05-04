package com.squad_17_api.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoDAO alunoDAO;

    @GetMapping
    public List<Aluno> getAlunos() {
        return alunoDAO.findAll();
    }

    @GetMapping("/{id}")
    public Aluno getAluno(@PathVariable int id) {
        return alunoDAO.findById(id).orElse(null);
    }

    @PostMapping
    public Aluno addAluno(@RequestBody Aluno aluno) {
        return alunoDAO.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable int id, @RequestBody Aluno aluno) {
        aluno.setIdAluno(id);
        return alunoDAO.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable int id) {
        alunoDAO.deleteById(id);
    }
}
