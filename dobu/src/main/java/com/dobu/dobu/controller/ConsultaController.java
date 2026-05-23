package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Consulta;
import com.dobu.dobu.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.dobu.dobu.dto.ConsultaRequestDTO;
import com.dobu.dobu.dto.ConsultaResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ConsultaResponseDTO> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ConsultaResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<ConsultaResponseDTO> buscar(@RequestParam String descricao){
        return service.buscarPorDescricao(descricao);
    }

    @PostMapping
    public ConsultaResponseDTO salvar(@Valid @RequestBody ConsultaRequestDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ConsultaResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ConsultaRequestDTO dto) {

        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
