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
    public Film createIngredient(@RequestBody Film newFilm) {
        return filmService.createFilm(newFilm);
    }

    @Operation(summary = "Seleziona un tutti i film" , description = "Restituisce i dati di tutti i film presenti nel database")
    @GetMapping("/")
    public List<Film> getAllFilm() {
        List<Film> listOfFilm = filmService.getAllFilm();
        for (Film film : listOfFilm) {
            film.setValutazioneMedia(recensioneService.getMedia(film.getId()));
        }
        return listOfFilm;
    }

    @Operation(summary = "Seleziona un film specifico" , description = "Restituisce i dati di un film specifico attraverso l'inserimento di un Id")
    @GetMapping("/{id}")
    public Optional<Film> getFilmById(@PathVariable Long id) {
        Optional<Film> filmOpt = filmService.getFilmById(id);
        filmOpt.get().setValutazioneMedia(recensioneService.getMedia(id));
        return filmOpt;
    }


    /*@GetMapping("/get/film/by-titolo")
    public List<Film> getFilmsByPartialTitle(@RequestParam String partialTitle) {
        return filmService.getFilmByPartialTitle(partialTitle);
    }*/

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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable Long id) {
        Optional<Film> filmOpt = filmService.deleteFilm(id);
        if(filmOpt.isPresent()){
            return ResponseEntity.ok("Film eliminato con successo!");
        }else{
            return ResponseEntity.badRequest().body("Film non trovato!");
        }

    }

}
