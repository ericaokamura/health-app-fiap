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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOMECOMPLETO")
    private String nomeCompleto;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PESO")
    private Double peso;
    @Column(name = "ALTURA")
    private Double altura;
    @Column(name = "IMC")
    private Double imc;
    @Column(name = "IDADE")
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
