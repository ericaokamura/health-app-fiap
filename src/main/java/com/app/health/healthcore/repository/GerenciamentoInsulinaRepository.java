package com.app.health.healthcore.repository;

import com.app.health.healthcore.model.GerenciamentoInsulina;
import com.app.health.healthcore.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GerenciamentoInsulinaRepository extends JpaRepository<GerenciamentoInsulina, Long> {

    List<GerenciamentoInsulina> findByUsuario(Usuario usuario);


}
