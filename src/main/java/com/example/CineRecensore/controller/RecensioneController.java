package com.example.CineRecensore.controller;

import com.example.CineRecensore.entity.Recensione;
import com.example.CineRecensore.service.RecensioneService;
import com.example.CineRecensore.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recensione")
public class RecensioneController {
    private final RecensioneService recensioneService;


    @Autowired
    public RecensioneController(RecensioneService recensioneService) {
        this.recensioneService = recensioneService;
    }

    @PostMapping("/insert")
    public Recensione createRecensione(@RequestBody Recensione recensione){
       return recensioneService.createRecensione(recensione);
    }

    @GetMapping("/getAll")
    public List<Recensione> getAll(){
        return recensioneService.getAllRecensioni();
    }





}
