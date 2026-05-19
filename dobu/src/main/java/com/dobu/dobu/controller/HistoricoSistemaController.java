package com.dobu.dobu.controller;

import com.dobu.dobu.entity.HistoricoSistema;
import com.dobu.dobu.service.HistoricoSistemaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historicos")
public class HistoricoSistemaController {

    private final HistoricoSistemaService service;

    public HistoricoSistemaController(HistoricoSistemaService service) {
        this.service = service;
    }

    @GetMapping
    public List<HistoricoSistema> listar() {
        return service.listar();
    }

    @PostMapping
    public HistoricoSistema salvar(@Valid @RequestBody HistoricoSistema historico) {
        return service.salvar(historico);
    }
}
