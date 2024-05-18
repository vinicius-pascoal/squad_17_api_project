package com.squad_17_api.demo.controller;

import com.squad_17_api.demo.model.Aluno;
import com.squad_17_api.demo.model.Curso;
import com.squad_17_api.demo.repository.AlunoRepository;
import com.squad_17_api.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.squad_17_api.demo.model.AlunoCurso;




@RestController
@RequestMapping("/api/matriculas")
public class AlunoCursoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping("/matricular")
    public ResponseEntity<String> matricularAlunoEmCurso(@RequestBody AlunoCurso alunoCurso) {
        Integer alunoId = alunoCurso.getAlunoId();
        Integer cursoId = alunoCurso.getCursoId();

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado com o ID fornecido."));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado com o ID fornecido."));

        aluno.getCursos().add(curso);
        alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body("Aluno matriculado com sucesso no curso.");
    }
}

