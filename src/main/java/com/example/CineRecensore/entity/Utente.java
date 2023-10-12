package com.example.CineRecensore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeUtente;
    private String email;
    private String password;
    private Enum ruolo;

    @OneToMany(mappedBy = "utente")
    private List<Recensione> recensioni;

    public Utente(Long id, String nomeUtente, String email, String password, Enum ruolo) {
        this.id = id;
        this.nomeUtente = nomeUtente;
        this.email = email;
        this.password = password;
        this.ruolo = ruolo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum getRuolo() {
        return ruolo;
    }

    public void setRuolo(Enum ruolo) {
        this.ruolo = ruolo;
    }
}
