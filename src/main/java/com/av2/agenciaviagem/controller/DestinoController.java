package com.av2.agenciaviagem.controller;

import com.av2.agenciaviagem.dto.AvaliacaoRequest;
import com.av2.agenciaviagem.dto.ReservaRequest;
import com.av2.agenciaviagem.model.Destino;
import com.av2.agenciaviagem.service.DestinoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

    private final DestinoService destinoService;

    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @PostMapping
    public ResponseEntity<Destino> cadastrar(@RequestBody Destino destino) {
        Destino novoDestino = destinoService.cadastrar(destino);
        return ResponseEntity.ok(novoDestino);
    }

    @GetMapping
    public ResponseEntity<List<Destino>> listarTodos() {
        return ResponseEntity.ok(destinoService.listarTodos());
    }

    @GetMapping("/pesquisa")
    public ResponseEntity<List<Destino>> pesquisar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String localizacao
    ) {
        return ResponseEntity.ok(destinoService.pesquisar(nome, localizacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> buscarPorId(@PathVariable Long id) {
        return destinoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/reserva")
    public ResponseEntity<Destino> reservar(
            @PathVariable Long id,
            @RequestBody ReservaRequest reservaRequest
    ) {
        return destinoService.reservar(id, reservaRequest.getNomeCliente())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/avaliacao")
    public ResponseEntity<?> avaliar(
            @PathVariable Long id,
            @RequestBody AvaliacaoRequest avaliacaoRequest
    ) {
        try {
            return destinoService.avaliar(id, avaliacaoRequest.getNota())
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException erro) {
            return ResponseEntity.badRequest().body(erro.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean excluido = destinoService.excluir(id);

        if (excluido) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}