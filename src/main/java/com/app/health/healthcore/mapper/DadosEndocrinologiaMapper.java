package com.app.health.healthcore.mapper;

import com.app.health.healthcore.dto.DadosEndocrinologiaDTO;
import com.app.health.healthcore.model.DadosEndocrinologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DadosEndocrinologiaMapper {

    @Autowired
    private GerenciamentoInsulinaMapper gerenciamentoInsulinaMapper;

    public DadosEndocrinologia convertToModel(DadosEndocrinologiaDTO dto) {
        if(dto != null) {
            DadosEndocrinologia dados = new
                    DadosEndocrinologia();
            dados.setCriadoEm(LocalDateTime.now());
            dados.setNivelGlicose(dto.getNivelGlicose());
            dados.setNivelHemoglobinaAc1(dto.getNivelHemoglobinaAc1());
            return dados;
        }
        return new DadosEndocrinologia();
    }

    public DadosEndocrinologiaDTO convertToDTO(DadosEndocrinologia model) {
        DadosEndocrinologiaDTO dto = new DadosEndocrinologiaDTO();
        dto.setCriadoEm(model.getCriadoEm());
        dto.setNivelGlicose(model.getNivelGlicose());
        dto.setNivelHemoglobinaAc1(model.getNivelHemoglobinaAc1());
        return dto;
    }

    public List<DadosEndocrinologia> convertToListModel(List<DadosEndocrinologiaDTO> dtos) {
        List<DadosEndocrinologia> dados = new ArrayList<>();
        for (DadosEndocrinologiaDTO dto : dtos) {
            dados.add(convertToModel(dto));
        }
        return dados;
    }

    public List<DadosEndocrinologiaDTO> convertToListDTO(List<DadosEndocrinologia> models) {
        List<DadosEndocrinologiaDTO> dados = new ArrayList<>();
        for (DadosEndocrinologia model : models) {
            dados.add(convertToDTO(model));
        }
        return dados;
    }

}

