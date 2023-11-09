package com.example.CineRecensore.service;

import com.example.CineRecensore.entity.Film;
import com.example.CineRecensore.entity.Recensione;
import com.example.CineRecensore.repository.FilmRepository;
import com.example.CineRecensore.repository.RecensioneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    private  FilmRepository filmRepository;

    @Autowired
    private RecensioneRepository recensioneRepository;


    public FilmService(FilmRepository filmRepository, RecensioneRepository recensioneRepository) {
        this.filmRepository = filmRepository;
        this.recensioneRepository = recensioneRepository;
    }

    public List<Film> getAllFilm() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Long id) {
        return filmRepository.findById(id);
    }


    public List<Film> getFilmByPartialTitle(String partialTitle) {
        return filmRepository.findFilmByPartialTitolo(partialTitle);
    }

    public Film createFilm(Film newFilm) {
            return filmRepository.save(newFilm);
    }


@Transactional
    public Optional<Film> updateFilm(Long id, Film film) {
        Optional<Film> filmOpt = filmRepository.findById(id);
        if (filmOpt.isPresent()) {
            recensioneRepository.deleteAllRecensioniByFilmId(id);
            filmOpt.get().setTitolo(film.getTitolo());
            filmOpt.get().setGenere(film.getGenere());
            filmOpt.get().setRegista(film.getRegista());
            filmOpt.get().setAnnoDiUscita(film.getAnnoDiUscita());
            filmRepository.save(filmOpt.get());
        }
           return filmOpt;
        }


    public Optional<Film> deleteFilm(Long id) {
        Optional<Film> filmOpt = filmRepository.findById(id);
        if ( filmOpt.isPresent()){
            filmRepository.deleteById(id);
        }
        return filmOpt;
    }

    public List<Film> classificaFilm(){
        return filmRepository.classificaFilm();
    }

    public void deleteAll(){
            filmRepository.deleteAll();
        }

    }


