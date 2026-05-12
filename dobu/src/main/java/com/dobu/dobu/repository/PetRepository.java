package com.dobu.dobu.repository;

import com.dobu.dobu.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}