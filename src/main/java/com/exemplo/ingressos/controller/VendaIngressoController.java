package com.exemplo.ingressos.controller;

import com.exemplo.ingressos.model.Compra;
import com.exemplo.ingressos.service.VendaIngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaIngressoController {

    @Autowired
    private VendaIngressoService vendaIngressoService;

    @PostMapping("/comprar")
    public ResponseEntity<String> comprarIngresso(
            @RequestParam Long ingressoId,
            @RequestParam String nome,
            @RequestParam String email,
            @RequestParam Integer quantidade) {

        String resultado = vendaIngressoService.comprarIngresso(ingressoId, nome, email, quantidade);
        return ResponseEntity.ok(resultado);
    }

    //consultar todas as compras feitas por um usuário.

    @GetMapping("/consultar-compras")
    public ResponseEntity<List<Compra>> consultarCompras(@RequestParam String email) {
        List<Compra> compras = vendaIngressoService.consultarComprasPorEmail(email);
        return ResponseEntity.ok(compras);
    }

    //consultar apenas as compras para eventos futuros.

    @GetMapping("/consultar-compras-futuras")
    public ResponseEntity<List<Compra>> consultarComprasFuturas(@RequestParam String email) {
        List<Compra> comprasFuturas = vendaIngressoService.consultarComprasFuturasPorEmail(email);
        return ResponseEntity.ok(comprasFuturas);
    }
}
