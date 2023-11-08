package com.example.CineRecensore.service;

import com.example.CineRecensore.entity.Utente;
import com.example.CineRecensore.repository.RecensioneRepository;
import com.example.CineRecensore.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private final UtenteRepository utenteRepository;


    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Autowired
    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> getUtenteById(Long id) {
        return utenteRepository.findById(id);
    }

    public List<Utente> getUtenteByRuolo(String ruolo){
        List<Utente> listOfAll = utenteRepository.findAll();
        List<Utente> listOfRuolo = new ArrayList<>();
        for (Utente utente : listOfAll) {
            if(Objects.equals(utente.getRuolo(), ruolo)){
                listOfRuolo.add(utente);
            }
        }
        return listOfRuolo;
    }

    public Utente createUtente(Utente utenteRequest) {
        return utenteRepository.save(utenteRequest);
    }

    public Utente updateUtente(Long id, Utente updatedNewUtente) {
        if (utenteRepository.existsById(id)) {
            updatedNewUtente.setId(id);
            return utenteRepository.save(updatedNewUtente);
        } else {
            throw new IllegalArgumentException("Utente non trovato!");
        }
    }

    public void deleteUtente(Long id) {
        utenteRepository.deleteById(id);
    }
}
