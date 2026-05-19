package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Raca;
import com.dobu.dobu.service.RacaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/racas")
public class RacaController {

    private final RacaService service;

    public RacaController(RacaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Raca> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Raca buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Raca salvar(@Valid @RequestBody Raca raca) {
        return service.salvar(raca);
    }

    @PutMapping("/{id}")
    public Raca atualizar(@PathVariable Long id,
                          @Valid @RequestBody Raca raca) {
        return service.atualizar(id, raca);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

