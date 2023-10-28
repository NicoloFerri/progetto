package com.example.CineRecensore.controller;

import com.example.CineRecensore.entity.Utente;
import com.example.CineRecensore.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    private final UtenteService utenteService;

    @Autowired
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }


    @PostMapping("/insert")
    public Utente createUtente(@RequestBody Utente utente){
        return utenteService.createUtente(utente);
    }

    @GetMapping("/getAll")
    public List<Utente> getaAll(){
        return utenteService.getAllUtenti();
    }

    @GetMapping("/getById/{id}")
    public Optional<Utente> getUtenteById (@PathVariable Long id){
        return utenteService.getUtenteById(id);
    }

    @GetMapping("/getByRuolo/{ruolo}")
  public List<Utente> getUtenteByRuolo (@PathVariable String ruolo){
        return utenteService.getUtenteByRuolo(ruolo);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById (@PathVariable Long id){
       utenteService.deleteUtente(id);
    }




}
