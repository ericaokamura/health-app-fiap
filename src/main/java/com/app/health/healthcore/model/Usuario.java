package com.app.health.healthcore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nomeCompleto;
    private String email;
    private Double peso;
    private Double altura;
    private Double imc;
    private Integer idade;
    @OneToMany
    @Transient
    private List<DadosEndocrinologia> listaDados = new ArrayList<>();
    @OneToMany
    @Transient
    private List<GerenciamentoInsulina> gerenciamentosInsulina = new ArrayList<>();

    public Double calculaImc() {
        this.imc = this.peso / (this.altura * this.altura);
        return this.imc;
    }
}
