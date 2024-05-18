package com.squad_17_api.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//model


public class AlunoCurso {

    private  Integer alunoId;
    private Integer cursoId;

    //sobrecarga de construtor
    public AlunoCurso(){

    }

    public AlunoCurso(Integer alunoId, Integer cursoId) {
        this.alunoId = alunoId;
        this.cursoId = cursoId;
    }
    //meotoodos getters e setters


    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }
}
