package com.squad_17_api.demo.repository;

import com.squad_17_api.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}
