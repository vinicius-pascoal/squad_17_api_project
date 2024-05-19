package com.squad_17_api.demo.service;

import com.squad_17_api.demo.model.Aula;

import java.util.List;

public interface AulaService {
    List<Aula> getAllAulas();
    Aula getAulaById(Integer id);
    Aula createAula(Aula aula);
    Aula updateAula(Integer id, Aula aula);
    void deleteAula(Integer id);
}
