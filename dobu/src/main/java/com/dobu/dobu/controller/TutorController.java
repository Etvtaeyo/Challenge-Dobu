package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Tutor;
import com.dobu.dobu.repository.TutorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tutores")
public class TutorController {

    private final TutorRepository repository;

    public TutorController(TutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Tutor salvar(@RequestBody Tutor tutor){
        return repository.save(tutor);
    }

    @GetMapping
    public List<Tutor> listar(){
        return repository.findAll();
    }
}