package com.app.health.healthcore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GerenciamentoInsulinaDTO {

    private LocalDateTime criadoEm;
    private String tipoInsulina;
    private String posologia;
}
