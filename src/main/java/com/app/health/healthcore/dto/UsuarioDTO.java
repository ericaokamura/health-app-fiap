package com.app.health.healthcore.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class UsuarioDTO {

    private String nomeCompleto;
    private String email;
    private Double peso;
    private Double altura;
    private Double imc;
    private Integer idade;
    private List<DadosEndocrinologiaDTO> listaDados = new ArrayList<>();
    private List<GerenciamentoInsulinaDTO> gerenciamentosInsulina = new ArrayList<>();

    public Double calculaImc() {
        this.imc = this.peso / (this.altura * this.altura);
        return this.imc;
    }
}
