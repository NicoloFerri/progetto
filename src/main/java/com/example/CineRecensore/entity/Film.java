package com.example.CineRecensore.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titolo;
    private String regista;
    private Integer annoDiUscita;
    private Enum genere;
    private String trama;
    private Double valutazioneMedia;

    @OneToMany(mappedBy = "film")
    private List<Recensione> recensioni;

    public Film(){

    }
    public Film(Long id, String titolo, String regista, Integer annoDiUscita, Enum genere, String trama, Double valutazioneMedia) {
        this.id = id;
        this.titolo = titolo;
        this.regista = regista;
        this.annoDiUscita = annoDiUscita;
        this.genere = genere;
        this.trama = trama;
        this.valutazioneMedia = valutazioneMedia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getRegista() {
        return regista;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public Integer getAnnoDiUscita() {
        return annoDiUscita;
    }

    public void setAnnoDiUscita(Integer annoDiUscita) {
        this.annoDiUscita = annoDiUscita;
    }

    public Enum getGenere() {
        return genere;
    }

    public void setGenere(Enum genere) {
        this.genere = genere;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public Double getValutazioneMedia() {
        return valutazioneMedia;
    }

    public void setValutazioneMedia(Double valutazioneMedia) {
        this.valutazioneMedia = valutazioneMedia;
    }
}
