package com.dobu.dobu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Sensor {

    @Id
    @GeneratedValue
    private Long id;

    private double temperatura;
    private boolean movimento;
    private LocalDateTime dataHora;

    @ManyToOne
    private Pet pet;
}
