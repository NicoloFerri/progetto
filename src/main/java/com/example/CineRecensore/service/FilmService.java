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
    /*public List<Film> getFilmByPartialTitle(String partialTitle) {
        return filmRepository.findFilmByPartialTitolo(partialTitle);
    }*/

    public Film createFilm(Film newFilm) {
            return filmRepository.save(newFilm);
    }

    public Optional<Film> updateFilm(Long id, Film film) {
        Optional<Film> filmOpt = filmRepository.findById(id);
        if (filmOpt.isPresent()) {
            filmOpt.get().setTitolo(film.getTitolo());
            filmOpt.get().setGenere(film.getGenere());
            filmOpt.get().setRegista(film.getRegista());
            filmOpt.get().setAnnoDiUscita(film.getAnnoDiUscita());
            filmRepository.save(filmOpt.get());
        }
           return filmOpt;
        }


    public void deleteFilm(Long id) {
        Optional<Film> filmOpt = filmRepository.findById(id);
        if ( filmOpt.isPresent()){
            filmRepository.deleteById(id);
        }
    }

}
