package com.dobu.dobu.repository;

import com.dobu.dobu.entity.Raca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RacaRepository extends JpaRepository<Raca, Long> {

    List<Raca> findByNomeContainingIgnoreCase(String nome);
}
