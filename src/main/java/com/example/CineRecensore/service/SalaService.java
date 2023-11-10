package com.example.CineRecensore.service;

import com.example.CineRecensore.entity.Sala;
import com.example.CineRecensore.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public Sala createSala(Sala sala){
        return salaRepository.save(sala);
    }

    public List<Sala> getAllSale(){
        return salaRepository.findAll();
    }

    public Optional<Sala> getSalaById(Long id){
        return salaRepository.findById(id);
    }


}
