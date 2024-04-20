package com.squad_17_api.demo.model;

import javax.persistence.*;


@Entity

public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_aluno;
    
    @Column(length = 80)
    private String nome;
    
    @Column(length = 85)
    private String email_aluno;
    
    @Column
    private int num_matricula;
    
    // Método para definir o ID do aluno
    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }
    
    // Outros getters e setters
    // Getter e setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e setter para email_aluno
    public String getEmail_aluno() {
        return email_aluno;
    }

    public void setEmail_aluno(String email_aluno) {
        this.email_aluno = email_aluno;
    }

    // Getter e setter para num_matricula
    public int getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(int num_matricula) {
        this.num_matricula = num_matricula;
    }
}
