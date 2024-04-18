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
}
