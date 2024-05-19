package com.squad_17_api.demo.controller;

import com.squad_17_api.demo.model.Aula;
import com.squad_17_api.demo.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping
    public List<Aula> getAllAulas() {
        return aulaService.getAllAulas();
    }

    @GetMapping("/{id}")
    public Aula getAulaById(@PathVariable Integer id) {
        return aulaService.getAulaById(id);
    }

    @PostMapping
    public Aula createAula(@RequestBody Aula aula) {
        return aulaService.createAula(aula);
    }

    @PutMapping("/{id}")
    public Aula updateAula(@PathVariable Integer id, @RequestBody Aula aula) {
        return aulaService.updateAula(id, aula);
    }

    @DeleteMapping("/{id}")
    public void deleteAula(@PathVariable Integer id) {
        aulaService.deleteAula(id);
    }
}
