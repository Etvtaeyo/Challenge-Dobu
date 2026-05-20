package com.dobu.dobu.repository;

import com.dobu.dobu.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByDescricaoContainingIgnoreCase(String descricao);

}

