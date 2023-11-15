package com.example.CineRecensore.service;

import com.example.CineRecensore.entity.Film;
import com.example.CineRecensore.entity.Sala;
import com.example.CineRecensore.entity.View;
import com.example.CineRecensore.repository.FilmRepository;
import com.example.CineRecensore.repository.SalaRepository;
import com.example.CineRecensore.repository.ViewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ViewService {

    @Autowired
    private ViewRepository viewRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SalaRepository salaRepository;

    public ViewService(ViewRepository viewRepository, FilmRepository filmRepository, SalaRepository salaRepository) {
        this.viewRepository = viewRepository;
        this.filmRepository = filmRepository;
        this.salaRepository = salaRepository;
    }

    public List<View> getAllView(){
        return viewRepository.findAll();
    }

    public Optional<View> getViewById(Long id){
        return viewRepository.findById(id);
    }


    public boolean createView(View view, Long id_film, Long id_sala){
        Optional<Film> filmOpt = filmRepository.findById(id_film);
        Optional<Sala> salaOpt = salaRepository.findById(id_sala);
        if(filmOpt.isPresent() && salaOpt.isPresent()){
            view.setFilm(filmOpt.get());
            view.setSala(salaOpt.get());
            viewRepository.save(view);
            return true;
        }
        return false;
    }


    public List<View> print(LocalDate date){
        return viewRepository.printDaysView(date);
    }






}
