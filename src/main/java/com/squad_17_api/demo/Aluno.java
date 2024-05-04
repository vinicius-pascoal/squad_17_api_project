package com.squad_17_api.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "Aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_aluno;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "email_aluno", nullable = false, length = 255)
    private String email_aluno;

    @Column(name = "num_matricula", nullable = false)
    private int num_matricula;

    public int getIdAluno() {
        return id_aluno;
    }

    public void setIdAluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailAluno() {
        return email_aluno;
    }

    public void setEmailAluno(String email_aluno) {
        this.email_aluno = email_aluno;
    }

    public int getNumMatricula() {
        return num_matricula;
    }

    public void setNumMatricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }
}
