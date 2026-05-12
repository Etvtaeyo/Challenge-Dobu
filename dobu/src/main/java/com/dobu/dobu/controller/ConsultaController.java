package com.dobu.dobu.controller;

import com.dobu.dobu.dto.ConsultaDTO;
import com.dobu.dobu.entity.Consulta;
import com.dobu.dobu.service.ConsultaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public Consulta salvar(@RequestBody ConsultaDTO dto){
        return service.salvar(dto);
    }
}
