package com.example.CineRecensore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer postiASedere;

    private Integer postiASedereRimasti;

    @OneToMany(mappedBy = "sala")
    private List<View> views;

    public Sala() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPostiASedere() {
        return postiASedere;
    }

    public void setPostiASedere(Integer postiASedere) {
        this.postiASedere = postiASedere;
    }


}
