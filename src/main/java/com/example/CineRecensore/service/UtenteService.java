package com.example.CineRecensore.service;

import com.example.CineRecensore.entity.Utente;
import com.example.CineRecensore.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
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

    public Utente createUtente(Utente newUtente) {
        return utenteRepository.save(newUtente);
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
