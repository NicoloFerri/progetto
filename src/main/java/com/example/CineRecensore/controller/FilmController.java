package com.example.CineRecensore.controller;

import com.example.CineRecensore.entity.Film;
import com.example.CineRecensore.entity.Recensione;
import com.example.CineRecensore.service.FilmService;
import com.example.CineRecensore.service.RecensioneService;
import com.example.CineRecensore.service.UtenteService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private final FilmService filmService;

    @Autowired
    private final RecensioneService recensioneService;


    public FilmController(FilmService filmService, RecensioneService recensioneService) {
        this.filmService = filmService;
        this.recensioneService = recensioneService;
    }

    @Operation(summary = "Aggiungi un film al database" , description = "Aggiunge un oggetto Film al database tramite l'inserimento di un file Json")
    @PostMapping("/")
    public Film createFilm (@RequestBody() Film newFilm) {
        return filmService.createFilm(newFilm);
            }

    @Operation(summary = "Seleziona un tutti i film" , description = "Restituisce i dati di tutti i film presenti nel database")
    @GetMapping("/")
    public List<Film> getAllFilm() {
        return filmService.getAllFilm();
    }

    @Operation(summary = "Seleziona un film specifico" , description = "Restituisce i dati di un film specifico attraverso l'inserimento di un Id")
    @GetMapping("/{id}")
    public Optional<Film> getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id);
    }


    @Operation(summary = "Restituisce una classifica dei Film" , description = "Crea una lista ordinata in funzione della valutazione media, in modo descescente")
    @GetMapping("/classifica")
    public List<Film> getClassifica(){
        return filmService.classificaFilm();
    }


@Operation(summary = "Restituisce una film specifico inserendo il titolo" , description = "Restituisce i dati di un film specifico attraverso l'inserimento del titolo o di una parte di esso")
    @GetMapping("/getByTitle/")
    public List<Film> getFilmsByPartialTitle(@RequestParam String partialTitle) {
        return filmService.getFilmByPartialTitle(partialTitle);
    }

    @Operation(summary = "Aggiornamento di un film esistente" , description = "Sostituisce i dati di un film presente con i dati che passiamo via Json, inoltre elimina tutte le recensioni effettuate sul film che è stato modificato")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateNewFilm(@PathVariable Long id, @RequestBody Film updatedNewFilm ) {
        Optional<Film> filmOpt = filmService.updateFilm(id, updatedNewFilm);
        if (filmOpt.isPresent()){
            return ResponseEntity.ok("Film aggiornato!");
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Eliminazione di un film esistente" , description = "Elimina i dati di un film specifico utilizzando l'inserimento di un Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable Long id) {
        Optional<Film> filmOpt = filmService.deleteFilm(id);
        if(filmOpt.isPresent()){
            return ResponseEntity.ok("Film eliminato con successo!");
        }else{
            return ResponseEntity.badRequest().body("Film non trovato!");
        }

    }

}
