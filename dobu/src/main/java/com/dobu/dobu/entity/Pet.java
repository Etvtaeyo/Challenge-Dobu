package com.dobu.dobu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Pet {

    @Id
    @GeneratedValue
    @ManyToOne
    private Tutor tutor;
    private Long id;


    private String nome;
    private String tipo;
    private String raca;
    private int idade;
    private double peso;
}
