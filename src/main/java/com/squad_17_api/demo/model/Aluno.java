package com.squad_17_api.demo.model;

import java.util.List;

import jakarta.persistence.*;

//model
@Entity
public class Aluno {
    @Id
    private Integer id;
    private Integer idUsuario;
    private String nome;
    private Integer matricula;

    @ManyToMany
    @JoinTable(name = "Alunocurso", joinColumns = @JoinColumn(name = "id_aluno"), inverseJoinColumns = @JoinColumn(name = "id_curso"))
    private List<Curso> cursos;



    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
