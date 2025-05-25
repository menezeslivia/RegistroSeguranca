package com.segurancaurbana.backend.repository;

import com.segurancaurbana.backend.model.Ocorrencia;
import com.segurancaurbana.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    List<Ocorrencia> findByUsuarioId(Long usuarioId);
    
    long countByUsuarioAndDataCriacaoBetween(Usuario usuario, LocalDateTime inicio, LocalDateTime fim);
}
