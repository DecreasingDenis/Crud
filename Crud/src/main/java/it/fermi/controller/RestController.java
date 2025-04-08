package it.fermi.controller;

import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController     // Short for @Controller + @ResponseBody

public class RestController {

    // Gestisce richiesta GET di /api/richiestaConParametri/hello
    @GetMapping("/richiestaConParametri/{param1}")
    public String richiestaConParametri(@PathVariable String param1, @RequestParam(required = false) String param2) {
        return param1 + " " + param2;  // Echoes la variabile del path come risposta
    }

    //gestione della richiesta di una somma
    @GetMapping("/richiestaPostConParametriNumerici/{param1}/{param2}")
    public String richiestaPostConParametri(@PathVariable int param1, @PathVariable int param2) {
        int sum = param1 + param2;
        return "somma: " + sum;
    }

}