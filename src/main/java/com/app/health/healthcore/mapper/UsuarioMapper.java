package com.app.health.healthcore.mapper;

import com.app.health.healthcore.dto.UsuarioDTO;
import com.app.health.healthcore.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UsuarioMapper {

    @Autowired
    private DadosEndocrinologiaMapper dadosEndocrinologiaMapper;

    @Autowired
    private GerenciamentoInsulinaMapper gerenciamentoInsulinaMapper;

    public Usuario convertToModel(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setIdade(dto.getIdade());
        usuario.setNomeCompleto(dto.getNomeCompleto());
        usuario.setAltura(dto.getAltura());
        usuario.setPeso(dto.getPeso());
        usuario.setImc(dto.calculaImc());
        usuario.setListaDados(new ArrayList<>());
        usuario.getListaDados().addAll(dadosEndocrinologiaMapper.convertToListModel(dto.getListaDados()));
        usuario.setGerenciamentosInsulina(new ArrayList<>());
        usuario.getGerenciamentosInsulina().addAll(gerenciamentoInsulinaMapper.convertToListModel(dto.getGerenciamentosInsulina()));
        return usuario;
    }

    public UsuarioDTO convertToDTO(Usuario model) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setEmail(model.getEmail());
        dto.setIdade(model.getIdade());
        dto.setNomeCompleto(model.getNomeCompleto());
        dto.setAltura(model.getAltura());
        dto.setPeso(model.getPeso());
        dto.setImc(model.calculaImc());
        dto.getListaDados().addAll(dadosEndocrinologiaMapper.convertToListDTO(model.getListaDados()));
        dto.getGerenciamentosInsulina().addAll(gerenciamentoInsulinaMapper.convertToListDTO(model.getGerenciamentosInsulina()));
        return dto;
    }
}
