package com.squad_17_api.demo.repository;

public class AlunoRepository {
    
}
package com.squad_17_api.demo.repository;

import com.squad_17_api.demo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
