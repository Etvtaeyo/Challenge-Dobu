package com.dobu.dobu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime data;
    private String descricao;

    @ManyToOne
    private Pet pet;

    @ManyToOne
    private Medico medico;
}