package com.example.CineRecensore.controller;

import com.example.CineRecensore.entity.View;
import com.example.CineRecensore.service.ViewService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {
    @Autowired
    private ViewService viewService;

    public ViewController(ViewService viewService) {
        this.viewService = viewService;
    }


   @PostMapping("/{id_film}/{id_sala}")
    public ResponseEntity<String> createView (@PathVariable Long id_film , @PathVariable Long id_sala, @RequestBody View view){
        boolean b = viewService.createView(view,id_film,id_sala);
        if(b){
            return ResponseEntity.ok("View creata con successo!");
        }
return ResponseEntity.badRequest().body("Errore nella creazione della view");
    }

    @GetMapping("/")
        public List<View> getAllView(){
            return viewService.getAllView();
        }
    }



