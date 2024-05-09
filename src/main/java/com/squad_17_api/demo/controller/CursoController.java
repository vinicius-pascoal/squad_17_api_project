package com.squad_17_api.demo.controller;
import com.squad_17_api.demo.model.Curso;
import com.squad_17_api.demo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> buscarTodos() {
        return ResponseEntity.ok(cursoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPortId(@PathVariable int id) {
        return ResponseEntity.ok(cursoService.buscarPorId(id).orElse(null));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Curso> addCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.criar(curso));
    }

//    @PutMapping("/{id}")
//    public Curso updateCurso(@PathVariable int id, @RequestBody Curso curso) {
//        curso.setId(id);
//        return cursoRepository.save(curso);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCurso(@PathVariable int id) {
//        cursoRepository.deleteById(id);
//    }
}
