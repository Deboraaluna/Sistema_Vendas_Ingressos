package com.exemplo.ingressos.controller;

import com.exemplo.ingressos.model.Ingresso;
import com.exemplo.ingressos.service.IngressoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

    @Autowired
    private IngressoService ingressoService;

    @PostMapping
    public ResponseEntity<Ingresso> criarIngresso(@Valid @RequestBody Ingresso ingresso) {
        Ingresso criado = ingressoService.criarIngresso(ingresso);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingresso> atualizarIngresso(@PathVariable Long id, @Valid @RequestBody Ingresso ingresso) {
        Ingresso atualizado = ingressoService.atualizarIngresso(id, ingresso);
        return new ResponseEntity<>(atualizado, HttpStatus.OK);
    }
}
