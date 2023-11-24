package com.app.health.healthcore.mapper;

import com.app.health.healthcore.dto.GerenciamentoInsulinaDTO;
import com.app.health.healthcore.enums.TipoInsulina;
import com.app.health.healthcore.model.GerenciamentoInsulina;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
public class GerenciamentoInsulinaMapper {

    public GerenciamentoInsulina convertToModel(GerenciamentoInsulinaDTO dto) {
        GerenciamentoInsulina dados = new
                GerenciamentoInsulina();
        dados.setCriadoEm(LocalDateTime.now());
        dados.setTipoInsulina(TipoInsulina.valueOf(dto.getTipoInsulina()));
        dados.setPosologia(dto.getPosologia());
        return dados;
    }

    public GerenciamentoInsulinaDTO convertToDTO(GerenciamentoInsulina model) {
        GerenciamentoInsulinaDTO dto = new
                GerenciamentoInsulinaDTO();
        dto.setCriadoEm(model.getCriadoEm().toString());
        dto.setTipoInsulina(model.getTipoInsulina().name());
        dto.setPosologia(model.getPosologia());
        return dto;
    }

    public List<GerenciamentoInsulina> convertToListModel(List<GerenciamentoInsulinaDTO> dtos) {
        List<GerenciamentoInsulina> models = new ArrayList<>();
        for (GerenciamentoInsulinaDTO dto : dtos) {
            models.add(convertToModel(dto));
        }
        return models;
    }

    public List<GerenciamentoInsulinaDTO> convertToListDTO(List<GerenciamentoInsulina> models) {
        List<GerenciamentoInsulinaDTO> dtos = new ArrayList<>();
        for (GerenciamentoInsulina model : models) {
            dtos.add(convertToDTO(model));
        }
        return dtos;
    }
}
