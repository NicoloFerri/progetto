package com.example.CineRecensore.service;

import com.example.CineRecensore.entity.Film;
import com.example.CineRecensore.entity.Utente;
import com.example.CineRecensore.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    private final FilmRepository filmRepository;


    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Autowired
    public List<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }

    //TODO metodo da implementare
    public List<Film> getFilmsByTitolo(String titolo) {
        return filmRepository.findFilmByTitolo(titolo);
    }

    public Film createFilm(Film newFilm) {
        return filmRepository.save(newFilm);
    }

    public Film updateFilm(Long id, Film updatedNewFilm) {
        if (filmRepository.existsById(id)) {
            updatedNewFilm.setId(id);
            return filmRepository.save(updatedNewFilm);
        } else {
            throw new IllegalArgumentException("Film non trovato!");
        }
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

}
