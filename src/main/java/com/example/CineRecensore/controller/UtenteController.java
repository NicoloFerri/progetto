package com.example.CineRecensore.controller;

import com.example.CineRecensore.entity.Utente;
import com.example.CineRecensore.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Aggiungi un utente", description = "Aggiungi un oggetto utente al database tramite un file Json")
    @PostMapping("/")
    public Utente createUtente(@RequestBody Utente utente){
        return utenteService.createUtente(utente);
    }

    @Operation(summary = "Seleziona tutti gli utenti", description = "Restituisce i dati di tutti gli utenti presenti nel database")
    @GetMapping("/")
    public List<Utente> getaAll(){
        return utenteService.getAllUtenti();
    }

    @Operation(summary = "Seleziona un utente specifico" , description = "Restituisce i dati di un utente specifico , selezionato attraverso l'inserimento di un" +
            "Id nell'endpoint")
    @GetMapping("/{id}")
    public Optional<Utente> getUtenteById (@PathVariable Long id){
        return utenteService.getUtenteById(id);
    }

    @Operation(summary = "Seleziona un utente specifico" , description = "Restituisce i dati di tutti gli utenti che hanno un determinato ruolo" +
            "inserito precedentemente nell'endpoint")
    @GetMapping("/{ruolo}")
  public List<Utente> getUtenteByRuolo (@PathVariable String ruolo){
        return utenteService.getUtenteByRuolo(ruolo);
    }

    @Operation(summary = "Elimina un Utente specifico", description = "Elimina un utente specifico , selezionato tramite l'inserimento di un " +
            "Id nell'endpoint, e le sue relative recensioni")
    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id){
       utenteService.deleteUtente(id);
    }




}
