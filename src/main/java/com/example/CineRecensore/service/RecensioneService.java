package com.example.CineRecensore.service;

import com.example.CineRecensore.entity.Film;
import com.example.CineRecensore.entity.Recensione;
import com.example.CineRecensore.entity.Utente;
import com.example.CineRecensore.repository.FilmRepository;
import com.example.CineRecensore.repository.RecensioneRepository;
import com.example.CineRecensore.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecensioneService {

    private final RecensioneRepository recensioneRepository;
    private final FilmRepository filmRepository;
    private final UtenteRepository utenteRepository;

    public RecensioneService(RecensioneRepository recensioneRepository, FilmRepository filmRepository, UtenteRepository utenteRepository) {
        this.recensioneRepository = recensioneRepository;
        this.filmRepository = filmRepository;
        this.utenteRepository = utenteRepository;
    }

    @Autowired
    public List<Recensione> getAllRecensioni() {
        return recensioneRepository.findAll();
    }

    public Optional<Recensione> getRecensioneById(Long id) {
        return recensioneRepository.findById(id);
    }

    public boolean createRecensione(Recensione newRecensione, Long id_film , Long id_utente) {
        Optional<Film> filmOpt = filmRepository.findById(id_film);
        Optional<Utente> utenteOpt = utenteRepository.findById(id_utente);
        if(filmOpt.isPresent() && utenteOpt.isPresent()){
            newRecensione.setFilm(filmOpt.get());
            newRecensione.setUtente(utenteOpt.get());
            filmOpt.get().addRecensioneToList(newRecensione);
            filmOpt.get().setValutazioneMedia(filmOpt.get().media());
            filmOpt.get().setNumeroRecensioni(filmOpt.get().numeroRecensioni());
            filmRepository.save(filmOpt.get());
            recensioneRepository.save(newRecensione);
            return true;
        }
        return false;
    }

    public Optional<Recensione> updateRecensione(Long id, Recensione recensione) {
        Optional<Recensione> recensioneOpt = recensioneRepository.findById(id);
        if(recensioneOpt.isPresent()){
            recensioneOpt.get().setDataRecensione(recensione.getDataRecensione());
            recensioneOpt.get().setTestoDellaRecensione(recensione.getTestoDellaRecensione());
            recensioneOpt.get().setValutazione(recensione.getValutazione());
            recensioneRepository.save(recensioneOpt.get());
        }
       return recensioneOpt;
    }

    public List<Recensione> getList (Long id){
        return recensioneRepository.findRecensioneByIdFilm(id);
    }

//    public Double getMedia(Long id){
//        List<Recensione> list = recensioneRepository.findRecensioneByIdFilm(id);
//        if(!list.isEmpty()){
//            int sum=0;
//            for (Recensione recensione : list) {
//                sum += recensione.getValutazione();
//            }
//            return (double)(sum/list.size());
//        }
//        return 0.0;
//    }

    public Optional<Recensione> deleteRecensioneById(Long id) {
        Optional<Recensione> recensioneOpt = recensioneRepository.findById(id);
        if (recensioneOpt.isPresent()) {
            recensioneOpt.get().getFilm().removeRecensioneToList(recensioneOpt.get());
            recensioneOpt.get().getFilm().setValutazioneMedia(recensioneOpt.get().getFilm().media());
            recensioneOpt.get().getFilm().setNumeroRecensioni(recensioneOpt.get().getFilm().numeroRecensioni());
            filmRepository.save(recensioneOpt.get().getFilm());
            recensioneRepository.deleteById(id);
        }
        return recensioneOpt;
    }

    }



