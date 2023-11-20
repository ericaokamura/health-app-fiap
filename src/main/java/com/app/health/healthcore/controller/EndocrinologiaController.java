package com.app.health.healthcore.controller;

import com.app.health.healthcore.dto.DadosEndocrinologiaDTO;
import com.app.health.healthcore.dto.GerenciamentoInsulinaDTO;
import com.app.health.healthcore.dto.UsuarioDTO;
import com.app.health.healthcore.service.EndocrinologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EndocrinologiaController {

    @Autowired
    private EndocrinologiaService service;

    @GetMapping("/usuarios/{idUsuario}")
    public ResponseEntity<UsuarioDTO> retornaDadosUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return ResponseEntity.ok(service.retornaDadosUsuario(idUsuario));
    }

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioDTO> gravaDadosUsuario(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(service.gravaDadosUsuario(dto));
    }

    @PostMapping("/usuarios/{idUsuario}/endocrinologia")
    public ResponseEntity<UsuarioDTO> gravaDadosEndocrinologiaUsuario(@PathVariable("idUsuario") Long idUsuario, @RequestBody DadosEndocrinologiaDTO dto) {
        return ResponseEntity.ok(service.gravaDadosEndocrinologia(idUsuario, dto));
    }

    @PutMapping("/usuarios/{idUsuario}/endocrinologia/{idDado}")
    public ResponseEntity<UsuarioDTO> atualizaDadosEndocrinologiaUsuario(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idDado") Long idDado, @RequestBody DadosEndocrinologiaDTO dto) {
        return ResponseEntity.ok(service.atualizaDadosEndocrinologia(idUsuario, idDado, dto));

    }

    @PostMapping("/usuarios/{idUsuario}/gerenciamentoInsulina")
    public ResponseEntity<UsuarioDTO> gravaGerenciamentoInsulinaUsuario(@PathVariable("idUsuario") Long idUsuario, @RequestBody GerenciamentoInsulinaDTO dto) {
        return ResponseEntity.ok(service.gravaGerenciamentoInsulina(idUsuario, dto));
    }

    @PutMapping("/usuarios/{idUsuario}/gerenciamentoInsulina/{idGerenciamento}")
    public ResponseEntity<UsuarioDTO> atualizaGerenciamentoInsulinaUsuario(@PathVariable("idUsuario") Long idUsuario, @PathVariable("idGerenciamento") Long idGerenciamento, @RequestBody GerenciamentoInsulinaDTO dto) {
        return ResponseEntity.ok(service.atualizaGerenciamentoInsulina(idUsuario, idGerenciamento, dto));
    }
}
