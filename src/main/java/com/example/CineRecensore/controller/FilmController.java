package com.example.CineRecensore.controller;

import com.example.CineRecensore.entity.Film;
import com.example.CineRecensore.entity.Recensione;
import com.example.CineRecensore.service.FilmService;
import com.example.CineRecensore.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/film")
public class FilmController {
    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/getAll")
    public List<Film> getAllFilm() {
        return filmService.getAllFilm();
    }

    @GetMapping("/getFilmById/{id}")
    public Optional<Film> getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id);
    }

    /*@GetMapping("/get/film/by-titolo")
    public List<Film> getFilmsByPartialTitle(@RequestParam String partialTitle) {
        return filmService.getFilmByPartialTitle(partialTitle);
    }*/

    @PostMapping("/add")
    public Film createIngredient(@RequestBody Film newFilm) {
       return filmService.createFilm(newFilm);
        }



    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateNewFilm(@PathVariable Long id, @RequestBody Film updatedNewFilm ) {
        Optional<Film> filmOpt = filmService.updateFilm(id, updatedNewFilm);
        if (filmOpt.isPresent()){
            return ResponseEntity.ok("Film aggiornato!");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
    }
}
