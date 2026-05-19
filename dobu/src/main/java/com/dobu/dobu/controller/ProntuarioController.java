package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Prontuario;
import com.dobu.dobu.service.ProntuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    private final ProntuarioService service;

    public ProntuarioController(ProntuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prontuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Prontuario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Prontuario salvar(@Valid @RequestBody Prontuario prontuario) {
        return service.salvar(prontuario);
    }

    @PutMapping("/{id}")
    public Prontuario atualizar(@PathVariable Long id,
                                @Valid @RequestBody Prontuario prontuario) {
        return service.atualizar(id, prontuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
