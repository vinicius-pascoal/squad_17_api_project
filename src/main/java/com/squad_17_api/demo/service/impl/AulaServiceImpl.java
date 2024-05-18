package com.squad_17_api.demo.service.impl;

import com.squad_17_api.demo.model.Aula;
import com.squad_17_api.demo.repository.AulaRepository;
import com.squad_17_api.demo.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaServiceImpl implements AulaService {

    private final AulaRepository aulaRepository;

    @Autowired
    public AulaServiceImpl(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    @Override
    public List<Aula> listarAulas() {
        return aulaRepository.findAll();
    }

    @Override
    public Optional<Aula> buscarAulaPorId(Long id) {
        return aulaRepository.findById(id);
    }

    @Override
    public Aula salvarAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public void atualizarAula(Aula aula) {
        aulaRepository.save(aula);
    }

    @Override
    public void deletarAula(Long id) {
        aulaRepository.deleteById(id);
    }
}
