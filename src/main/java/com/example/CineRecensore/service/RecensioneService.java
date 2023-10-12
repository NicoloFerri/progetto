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

    public Recensione updateRecensione(Long id, Recensione updatedNewRecensione) {
        if (recensioneRepository.existsById(id)) {
            updatedNewRecensione.setId(id);
            return recensioneRepository.save(updatedNewRecensione);
        } else {
            throw new IllegalArgumentException("Recensione non trovata!");
        }
    }

    public void deleteRecensione(Long id) {
        recensioneRepository.deleteById(id);
    }
}
