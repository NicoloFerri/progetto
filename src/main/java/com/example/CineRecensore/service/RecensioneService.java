package com.example.CineRecensore.service;

import com.example.CineRecensore.entity.Recensione;
import com.example.CineRecensore.entity.Utente;
import com.example.CineRecensore.repository.RecensioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecensioneService {

    private final RecensioneRepository recensioneRepository;

    public RecensioneService(RecensioneRepository recensioneRepository) {
        this.recensioneRepository = recensioneRepository;
    }

    @Autowired
    public List<Recensione> getAllRecensioni() {
        return recensioneRepository.findAll();
    }

    public Optional<Recensione> getRecensioneById(Long id) {
        return recensioneRepository.findById(id);
    }

    public Recensione createRecensione(Recensione newRecensione) {
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

    public void deleteRecensione(Long id) {
        Optional<Recensione> recensioneOpt = recensioneRepository.findById(id);
        if (recensioneOpt.isPresent()) {
            recensioneRepository.deleteById(id);
        }
    }
}
