package com.dobu.dobu.repository;

import com.dobu.dobu.entity.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {

    List<Vacina> findByProximaDoseBetween(LocalDate inicio, LocalDate fim);

}

