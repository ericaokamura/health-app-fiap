package com.app.health.healthcore.repository;

import com.app.health.healthcore.model.DadosEndocrinologia;
import com.app.health.healthcore.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EndocrinologiaRepository extends JpaRepository<DadosEndocrinologia, Long> {

    List<DadosEndocrinologia> findByUsuario(Usuario usuario);
}
