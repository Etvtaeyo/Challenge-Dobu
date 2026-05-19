package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Especie;
import com.dobu.dobu.service.EspecieService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especies")
public class EspecieController {

    private final EspecieService service;

    public EspecieController(EspecieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Especie> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Especie buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Especie salvar(@Valid @RequestBody Especie especie) {
        return service.salvar(especie);
    }

    @PutMapping("/{id}")
    public Especie atualizar(@PathVariable Long id,
                             @Valid @RequestBody Especie especie) {
        return service.atualizar(id, especie);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}