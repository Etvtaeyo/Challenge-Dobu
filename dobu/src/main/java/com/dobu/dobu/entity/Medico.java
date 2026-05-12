package com.dobu.dobu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Medico {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String especialidade;
}
