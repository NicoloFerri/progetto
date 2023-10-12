package com.example.CineRecensore.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String testoDellaRecensione;
    private Integer valutazione;
    private LocalDate dataRecensione;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    public Recensione(Long id, String testoDellaRecensione, Integer valutazione, LocalDate dataRecensione) {
        this.id = id;
        this.testoDellaRecensione = testoDellaRecensione;
        this.valutazione = valutazione;
        this.dataRecensione = dataRecensione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestoDellaRecensione() {
        return testoDellaRecensione;
    }

    public void setTestoDellaRecensione(String testoDellaRecensione) {
        this.testoDellaRecensione = testoDellaRecensione;
    }

    public Integer getValutazione() {
        return valutazione;
    }

    public void setValutazione(Integer valutazione) {
        this.valutazione = valutazione;
    }

    public LocalDate getDataRecensione() {
        return dataRecensione;
    }

    public void setDataRecensione(LocalDate dataRecensione) {
        this.dataRecensione = dataRecensione;
    }
}
