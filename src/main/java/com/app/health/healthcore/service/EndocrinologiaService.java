package com.app.health.healthcore.service;

import com.app.health.healthcore.dto.DadosEndocrinologiaDTO;
import com.app.health.healthcore.dto.GerenciamentoInsulinaDTO;
import com.app.health.healthcore.dto.UsuarioDTO;
import com.app.health.healthcore.exceptions.DadosEndocrinologiaNaoExistenteException;
import com.app.health.healthcore.exceptions.GerenciamentoNaoExistenteException;
import com.app.health.healthcore.exceptions.UsuarioJaExistenteException;
import com.app.health.healthcore.exceptions.UsuarioNaoEncontradoException;
import com.app.health.healthcore.mapper.DadosEndocrinologiaMapper;
import com.app.health.healthcore.mapper.GerenciamentoInsulinaMapper;
import com.app.health.healthcore.mapper.UsuarioMapper;
import com.app.health.healthcore.model.DadosEndocrinologia;
import com.app.health.healthcore.model.GerenciamentoInsulina;
import com.app.health.healthcore.model.Usuario;
import com.app.health.healthcore.repository.EndocrinologiaRepository;
import com.app.health.healthcore.repository.GerenciamentoInsulinaRepository;
import com.app.health.healthcore.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EndocrinologiaService {

    @Autowired
    private EndocrinologiaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GerenciamentoInsulinaRepository gerenciamentoInsulinaRepository;

    @Autowired
    private DadosEndocrinologiaMapper mapper;

    @Autowired
    private GerenciamentoInsulinaMapper gerenciamentoInsulinaMapper;

    @Autowired
    private UsuarioMapper usuarioMapper;


    public UsuarioDTO gravaDadosUsuario(UsuarioDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(dto.getEmail());
        if(usuario.isPresent()) {
            throw new UsuarioJaExistenteException("Usuário já cadastrado.");
        }
        Usuario user = usuarioMapper.convertToModel(dto);
        Usuario retorno = usuarioRepository.save(user);
        List<DadosEndocrinologia> dadosEndocrinologias = user.getListaDados();
        dadosEndocrinologias.forEach(d -> {
            d.setUsuario(user);
            d.setCriadoEm(LocalDateTime.now());
        });
        if(!user.getListaDados().isEmpty()){
            repository.saveAll(dadosEndocrinologias);
        }
        List<GerenciamentoInsulina> gerenciamentoInsulinas = user.getGerenciamentosInsulina();
        gerenciamentoInsulinas.forEach(d -> {
            d.setUsuario(user);
            d.setCriadoEm(LocalDateTime.now());
        });
        if(!user.getGerenciamentosInsulina().isEmpty()){
            gerenciamentoInsulinaRepository.saveAll(gerenciamentoInsulinas);
        }
        return usuarioMapper.convertToDTO(retorno);
    }

    public UsuarioDTO retornaDadosUsuario(Long idUsuario) throws UsuarioNaoEncontradoException {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
        }
        Usuario user = usuario.get();
        List<DadosEndocrinologia> dados = repository.findByUsuario(user);
        user.setListaDados(dados);
        List<GerenciamentoInsulina> gerenciamentoInsulinas = gerenciamentoInsulinaRepository.findByUsuario(user);
        user.setGerenciamentosInsulina(gerenciamentoInsulinas);
        return usuarioMapper.convertToDTO(user);
    }

    public UsuarioDTO gravaDadosEndocrinologia(Long idUsuario, DadosEndocrinologiaDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
        }
        Usuario user = usuario.get();
        DadosEndocrinologia entity = mapper.convertToModel(dto);
        entity.setUsuario(user);
        repository.save(entity);
        List<DadosEndocrinologia> dados = repository.findByUsuario(user);
        user.setListaDados(dados);
        user.setGerenciamentosInsulina(gerenciamentoInsulinaRepository.findByUsuario(user));
        return usuarioMapper.convertToDTO(user);
    }

    public UsuarioDTO atualizaDadosEndocrinologia(Long idUsuario, Long idDado, DadosEndocrinologiaDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
        }
        Usuario user = usuario.get();
        Optional<DadosEndocrinologia> dado = repository.findById(idDado);
        if(dado.isEmpty()) {
            throw new DadosEndocrinologiaNaoExistenteException("Dado de endocrinologia não encontrado.");
        }
        DadosEndocrinologia updateEntity = mapper.convertToModel(dto);
        updateEntity.setUsuario(user);
        updateEntity.setId(idDado);
        repository.save(updateEntity);
        List<DadosEndocrinologia> dados = repository.findByUsuario(user);
        user.setListaDados(dados);
        user.setGerenciamentosInsulina(gerenciamentoInsulinaRepository.findByUsuario(user));
        return usuarioMapper.convertToDTO(user);
    }

    public UsuarioDTO gravaGerenciamentoInsulina(Long idUsuario, GerenciamentoInsulinaDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
        }
        Usuario user = usuario.get();
        GerenciamentoInsulina entity = gerenciamentoInsulinaMapper.convertToModel(dto);
        entity.setUsuario(user);
        gerenciamentoInsulinaRepository.save(entity);
        List<DadosEndocrinologia> dados = repository.findByUsuario(user);
        user.setListaDados(dados);
        user.setGerenciamentosInsulina(gerenciamentoInsulinaRepository.findByUsuario(user));
        return usuarioMapper.convertToDTO(user);
    }

    public UsuarioDTO atualizaGerenciamentoInsulina(Long idUsuario, Long idGerenciamento, GerenciamentoInsulinaDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuário não encontrado.");
        }
        Usuario user = usuario.get();
        Optional<GerenciamentoInsulina> gerenciamentoInsulina = gerenciamentoInsulinaRepository.findById(idGerenciamento);
        if(gerenciamentoInsulina.isEmpty()) {
            throw new GerenciamentoNaoExistenteException("Gerenciamento de insulina não encontrado.");
        }
        GerenciamentoInsulina updateEntity = gerenciamentoInsulinaMapper.convertToModel(dto);
        updateEntity.setUsuario(user);
        updateEntity.setId(idGerenciamento);
        gerenciamentoInsulinaRepository.save(updateEntity);
        List<DadosEndocrinologia> dados = repository.findByUsuario(user);
        user.setListaDados(dados);
        user.setGerenciamentosInsulina(gerenciamentoInsulinaRepository.findByUsuario(user));
        return usuarioMapper.convertToDTO(user);
    }


}
