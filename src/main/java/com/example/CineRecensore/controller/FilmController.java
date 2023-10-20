package com.example.CineRecensore.controller;

import com.example.CineRecensore.entity.Film;
import com.example.CineRecensore.service.FilmService;
import com.example.CineRecensore.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/film")
public class FilmController {
    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/get/all-film")
    public List<Film> getAllFilm() {
        return filmService.getAllFilm();
    }

    @GetMapping("/get/by-id/{id}")
    public ResponseEntity<Optional<Film>> getFilmById(@PathVariable Long id) {
        Optional<Film> optionalFilm = filmService.getFilmById(id);
        if(optionalFilm.isPresent()){
            return ResponseEntity.ok(optionalFilm);
        }else return ResponseEntity.notFound().build();
    }

    @GetMapping("/get/by-titolo")
    public List<Film> getFilmsByPartialTitle(@RequestParam String partialTitle) {
        return filmService.getFilmByPartialTitle(partialTitle);
    }

    @PostMapping("/add/")
    public Film createIngredient(@RequestBody Film newFilm) {
        return filmService.createFilm(newFilm);
    }

    @PutMapping("/update/{id}/")
    public ResponseEntity<Optional<Film>> updateNewFilm(@PathVariable Long id, @RequestBody Film updatedNewFilm ) {
        Optional<Film> optionalFilm = filmService.updateFilm(id, updatedNewFilm);
        if(optionalFilm.isPresent()){
            return ResponseEntity.ok(optionalFilm);
        }else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Optional<Film>> deleteFilm(@PathVariable Long id) {
        Optional<Film> optionalFilm = filmService.deleteFilm(id);
        if(optionalFilm.isPresent()){
            return ResponseEntity.ok(optionalFilm);
        }else return ResponseEntity.notFound().build();
    }
}
