package com.example.CineRecensore.controller;

import com.example.CineRecensore.entity.Recensione;
import com.example.CineRecensore.service.RecensioneService;
import com.example.CineRecensore.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recensione")
public class RecensioneController {
    private final RecensioneService recensioneService;


    @Autowired
    public RecensioneController(RecensioneService recensioneService) {
        this.recensioneService = recensioneService;
    }

    @Operation(summary = "Aggiungi una recensione di un film specifico effettuata da un utente specifico" ,
               description = "Aggiunge una recesione tramite l'inserimento di un file Json come body , assocciata a uno specifico film e uno" +
                       "specifico utente, tramite l'inserimento dei relativi Id nell'endpoint")
    @PostMapping("/{id_film}/{id_utente}")
    public ResponseEntity<String> createRecensione(@PathVariable Long id_film , @PathVariable Long id_utente , @RequestBody Recensione recensione){
        boolean b = recensioneService.createRecensione(recensione,id_film,id_utente);
       if(b){
           return ResponseEntity.ok("Recensione inserita con successo!");
       }
       return ResponseEntity.badRequest().body("Errore nell'inserimento della recensione!");
    }

    @Operation(summary="Seleziona tutte le recensioni" , description = "Genera un lista di tutte le recensioni presenti a database")
    @GetMapping("/")
    public List<Recensione> getAll(){
        return recensioneService.getAllRecensioni();
    }



    @Operation(summary = "Seleziona una recensione specifica" , description = "Seleziona una recensione specifica tramite l'inserimento di" +
            "un Id nell'endpoint")
    @GetMapping("/{id}")
    public ResponseEntity<?> getRecensioneById (@PathVariable Long id){
        Optional recensioneOpt = recensioneService.getRecensioneById(id);
        String errore = "Id inserito non corrispondete a nessuna recensione";
        if(recensioneOpt.isPresent()){
            return ResponseEntity.ok(recensioneOpt.get());
        }
        return  ResponseEntity.ok(errore);
    }


    @Operation(summary = "Calcolo media recensioni", description = "Calcola la media delle recensioni effettuate su un film specifico , selezionato" +
            "tramite l'inserimento di un Id nell'endpoint")
    @GetMapping("/media/{id}")
    public ResponseEntity<String> mediaRecensioni (@PathVariable Long id){
        Double media = recensioneService.getMedia(id);
        if(media!=0) {
            return ResponseEntity.ok("la media delle recensioni per il film selezionato è = " + media);
        }
        return ResponseEntity.badRequest().body("il film selezionato non ha avuto recensioni!");
    }


    @Operation(summary="Restituisce tutte le recensioni effettuate su un film specifico" , description = "Tramite l'inserimento di un Id relativo a un film specifico nell'endpoint restituisce " +
            "tutte le recensioni effettuate su quel film ")
    @GetMapping("/OfFilm/{id}")
    public List<Recensione> getList(@PathVariable Long id) {
        return recensioneService.getList(id);
    }

    @Operation(summary = "Elimina una recensione specifica" , description = "Tramite l'inserimento di un Id è possibile eliminare una specifica recensione")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecensioneById (@PathVariable Long id){
        Optional<Recensione> recensioneOpt = recensioneService.deleteRecensioneById(id);
        if(recensioneOpt.isPresent()){
            return ResponseEntity.ok("Recensione " + id
                                      + " effettuata dall'utente " + recensioneOpt.get().getUtente().getNomeUtente() + " in data : "
                                      + recensioneOpt.get().getDataRecensione() +
                                     "\n eliminata con successo!");
        }
        return ResponseEntity.badRequest().body("Nessuna recensione trovata per l'Id inserito!");
    }





}
