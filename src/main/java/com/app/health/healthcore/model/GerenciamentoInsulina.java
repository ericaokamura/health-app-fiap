package com.app.health.healthcore.model;

import com.app.health.healthcore.enums.TipoInsulina;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class GerenciamentoInsulina {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private LocalDateTime criadoEm;
    private TipoInsulina tipoInsulina;
    private String posologia;
}
