package com.exemplo.ingressos.controller;

import com.exemplo.ingressos.model.Evento;
import com.exemplo.ingressos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;
/*
      usei a notação do @Getmapping do Spring MVC para associar uma URL
      específica de uma requisição HTTP (GET, POST, PUT, DELETE)
      ao (Controller).
    */
    @PostMapping
    public Evento criarEvento(@RequestBody Evento evento) {
        return eventoService.criarEvento(evento);
    }

    @GetMapping("/verificar-conflito")
    public boolean verificarConflito(@RequestParam("data") String data, @RequestParam("local") String local) {
        return eventoService.verificarConflitoDeHorario(LocalDate.parse(data), local);
    }
}
