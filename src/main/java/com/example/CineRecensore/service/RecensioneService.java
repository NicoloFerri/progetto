package com.example.CineRecensore.service;

import com.example.CineRecensore.entity.Film;
import com.example.CineRecensore.entity.Recensione;
import com.example.CineRecensore.entity.Utente;
import com.example.CineRecensore.repository.FilmRepository;
import com.example.CineRecensore.repository.RecensioneRepository;
import com.example.CineRecensore.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Recensione createRecensione(Recensione newRecensione, Long id_film , Long id_utente) {
        Optional<Film> fimlOpt = filmRepository.findById(id_film);
        Optional<Utente> utenteOpt = utenteRepository.findById(id_utente);
        newRecensione.setFilm(fimlOpt.get());
        newRecensione.setUtente(utenteOpt.get());
        return recensioneRepository.save(newRecensione);
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

    public void deleteRecensioneById(Long id) {
        Optional<Recensione> recensioneOpt = recensioneRepository.findById(id);
        if (recensioneOpt.isPresent()) {
            recensioneRepository.deleteById(id);
        }
    }


}
