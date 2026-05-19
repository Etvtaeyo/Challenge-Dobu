package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Vacina;
import com.dobu.dobu.service.VacinaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

    private final VacinaService service;

    public VacinaController(VacinaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vacina> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Vacina buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Vacina salvar(@Valid @RequestBody Vacina vacina) {
        return service.salvar(vacina);
    }

    @PutMapping("/{id}")
    public Vacina atualizar(@PathVariable Long id,
                            @Valid @RequestBody Vacina vacina) {
        return service.atualizar(id, vacina);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
