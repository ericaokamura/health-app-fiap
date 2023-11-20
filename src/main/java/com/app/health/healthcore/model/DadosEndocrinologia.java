package com.app.health.healthcore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class DadosEndocrinologia {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private LocalDateTime criadoEm;
    private Double nivelGlicose;
    private Double nivelHemoglobinaAc1;






}
