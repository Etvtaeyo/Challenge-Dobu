package com.dobu.dobu.controller;

import com.dobu.dobu.entity.Pet;
import com.dobu.dobu.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetController {

    @Autowired
    private PetRepository repository;

    @PostMapping
    public Pet salvar(@RequestBody Pet pet){
        return repository.save(pet);
    }

    @GetMapping
    public List<Pet> listar(){
        return repository.findAll();
    }
}
