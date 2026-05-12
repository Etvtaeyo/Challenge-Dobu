package com.dobu.dobu.repository;

import com.dobu.dobu.entity.Consulta;
import com.dobu.dobu.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByMedicoAndData(Medico medico, LocalDateTime data);

}
