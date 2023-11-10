package com.example.CineRecensore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.Duration;
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
    private String genere;
    private String trama;
    private Duration durataFilm;
    private Double valutazioneMedia;
    private Integer numeroRecensioni;

    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private List<Recensione> recensioni;

    @OneToOne(mappedBy = "film")
    private View view;



    public Film(){

    }

    public Film(Long id, String titolo, String regista, Integer annoDiUscita, String genere, String trama, Duration durataFilm, Double valutazioneMedia, Integer numeroRecensioni) {
        this.id = id;
        this.titolo = titolo;
        this.regista = regista;
        this.annoDiUscita = annoDiUscita;
        this.genere = genere;
        this.trama = trama;
        this.durataFilm = durataFilm;
        this.valutazioneMedia = valutazioneMedia;
        this.numeroRecensioni = numeroRecensioni;
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

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
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

    public Integer getNumeroRecensioni() {
        return numeroRecensioni;
    }

    public void setNumeroRecensioni(Integer numeroRecensioni) {
        this.numeroRecensioni = numeroRecensioni;
    }

    public List<Recensione> getRecensioni() {
        return recensioni;
    }

    public void setRecensioni(List<Recensione> recensioni) {
        this.recensioni = recensioni;
    }

    public void addRecensioneToList(Recensione recensione){
        recensioni.add(recensione);
    }

    public Duration getDurataFilm() {
        return durataFilm;
    }

    public void setDurataFilm(Duration durataFilm) {
        this.durataFilm = durataFilm;
    }

    public double media(){
        int sum=0;
        for (Recensione recensione : recensioni) {
            sum+=recensione.getValutazione();
        }
        if(sum!=0){
            return (double)(sum/recensioni.size());
        }
        return 0;

    }

    public int numeroRecensioni(){
        return recensioni.size();
    }

    public void removeRecensioneToList(Recensione recensione){
        recensioni.remove(recensione);
    }
}
