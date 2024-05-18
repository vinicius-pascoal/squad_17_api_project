package com.squad_17_api.demo.controller;

import com.squad_17_api.demo.model.Aula;
import com.squad_17_api.demo.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    private final AulaService aulaService;

    @Autowired
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping
    public ResponseEntity<List<Aula>> listarAulas() {
        List<Aula> aulas = aulaService.listarAulas();
        return ResponseEntity.ok(aulas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> buscarAulaPorId(@PathVariable Long id) {
        Optional<Aula> aula = aulaService.buscarAulaPorId(id);
        return aula.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aula> salvarAula(@RequestBody Aula aula) {
        Aula savedAula = aulaService.salvarAula(aula);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> atualizarAula(@PathVariable Long id, @RequestBody Aula aula) {
        aula.setId(id);
        aulaService.atualizarAula(aula);
        return ResponseEntity.ok(aula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAula(@PathVariable Long id) {
        aulaService.deletarAula(id);
        return ResponseEntity.noContent().build();
    }
}
