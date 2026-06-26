package br.infnet.hospitalapi.controllers;

import br.infnet.hospitalapi.domain.Consulta;
import br.infnet.hospitalapi.services.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Consulta> cadastrar(
            @RequestParam Long pacienteId,
            @RequestParam Long medicoId,
            @RequestParam(required = false) String observacoes) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(pacienteId, medicoId, observacoes));
    }
}