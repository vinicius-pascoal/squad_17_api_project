package com.squad_17_api.demo.repository;

import com.squad_17_api.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
}
