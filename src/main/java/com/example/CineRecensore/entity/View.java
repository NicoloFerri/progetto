package com.example.CineRecensore.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "view")
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate data;
    private LocalTime orario;

    @OneToOne
    @JoinColumn(name="film_id")
    private Film film;

    @OneToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;


    public View() {
    }

    public View(Long id, LocalDate data, LocalTime orario, Film film, Sala sala) {
        this.id = id;
        this.data = data;
        this.orario = orario;
        this.film = film;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOrario() {
        return orario;
    }

    public void setOrario(LocalTime orario) {
        this.orario = orario;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
