package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Sensor;
import com.dobu.dobu.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @PostMapping
    public Sensor salvar(@RequestBody Sensor sensor){
        return service.salvar(sensor);
    }

    @GetMapping("/pet/{id}")
    public List<Sensor> listar(@PathVariable Long id){
        return service.listarPorPet(id);
    }
}
