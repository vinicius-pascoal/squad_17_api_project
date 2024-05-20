package com.squad_17_api.demo.service.impl;

import com.squad_17_api.demo.model.Aula;
import com.squad_17_api.demo.repository.AulaRepository;
import com.squad_17_api.demo.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public List<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    @Override
    public Aula getAulaById(Integer id) {
        return aulaRepository.findById(id).orElse(null);
    }

    @Override
    public Aula createAula(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public Aula updateAula(Integer id, Aula aula) {
        Aula existingAula = aulaRepository.findById(id).orElse(null);
        if (existingAula != null) {
            existingAula.setTitulo(aula.getTitulo());
            existingAula.setData(aula.getData());
            existingAula.setHoraInicio(aula.getHoraInicio());
            existingAula.setHoraFim(aula.getHoraFim());
            return aulaRepository.save(existingAula);
        }
        return null;
    }

    @Override
    public void deleteAula(Integer id) {
        aulaRepository.deleteById(id);
    }
}
