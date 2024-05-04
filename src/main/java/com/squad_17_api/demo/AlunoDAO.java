package com.squad_17_api.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoDAO extends JpaRepository<Aluno, Integer> {
}
