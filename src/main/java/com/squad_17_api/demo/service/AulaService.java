package com.squad_17_api.demo.service;

import com.squad_17_api.demo.model.Aula;

import java.util.List;
import java.util.Optional;

public interface AulaService {
    List<Aula> listarAulas();

    Optional<Aula> buscarAulaPorId(Long id);

    Aula salvarAula(Aula aula);

    void atualizarAula(Aula aula);

    void deletarAula(Long id);
}
