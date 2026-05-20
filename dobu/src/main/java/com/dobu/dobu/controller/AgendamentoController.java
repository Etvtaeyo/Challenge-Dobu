package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Agendamento;
import com.dobu.dobu.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Agendamento> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public Agendamento buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Agendamento salvar(@Valid @RequestBody Agendamento agendamento) {
        return service.salvar(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento atualizar(@PathVariable Long id,
                                 @Valid @RequestBody Agendamento agendamento) {
        return service.atualizar(id, agendamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
