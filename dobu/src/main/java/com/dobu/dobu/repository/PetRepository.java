package com.dobu.dobu.repository;

import com.dobu.dobu.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByNomeContainingIgnoreCase(String nome);
}