package com.app.health.healthcore.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DadosEndocrinologiaDTO {

    private LocalDateTime criadoEm;
    private Double nivelGlicose;
    private Double nivelHemoglobinaAc1;

}
