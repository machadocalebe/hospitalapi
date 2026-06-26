package br.infnet.hospitalapi.controllers;

import br.infnet.hospitalapi.domain.Medico;
import br.infnet.hospitalapi.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Medico> cadastrar(@Valid @RequestBody Medico medico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(medico));
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<Medico>> obterRanking() {
        return ResponseEntity.ok(service.obterRankingMedicos());
    }
}