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

    public Recensione(){

    }

    public Recensione(Long id, String testoDellaRecensione, Integer valutazione, LocalDate dataRecensione, Film film, Utente utente) {
        this.id = id;
        this.testoDellaRecensione = testoDellaRecensione;
        this.valutazione = valutazione;
        this.dataRecensione = dataRecensione;
        this.film = film;
        this.utente = utente;
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
