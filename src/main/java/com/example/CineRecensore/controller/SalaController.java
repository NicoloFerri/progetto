package com.example.CineRecensore.controller;


import com.example.CineRecensore.entity.Sala;
import com.example.CineRecensore.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping("/")
    public Sala createSala(@RequestBody Sala sala){
        return salaService.createSala(sala);
    }





}
