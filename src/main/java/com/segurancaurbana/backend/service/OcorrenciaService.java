package com.segurancaurbana.backend.service;

import com.segurancaurbana.backend.model.Ocorrencia;
import com.segurancaurbana.backend.model.Usuario;
import com.segurancaurbana.backend.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    public Ocorrencia criarOcorrencia(Ocorrencia ocorrencia, Usuario usuario) {
        // Limite de 3 ocorrências por dia por usuário
        LocalDateTime inicioDia = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime agora = LocalDateTime.now();

        long count = repository.countByUsuarioAndDataCriacaoBetween(usuario, inicioDia, agora);
        if (count >= 3) {
            throw new RuntimeException("Limite de 3 ocorrências por dia atingido!");
        }

        ocorrencia.setUsuario(usuario);
        ocorrencia.setStatus("PENDENTE");
        ocorrencia.setDataCriacao(LocalDateTime.now());

        return repository.save(ocorrencia);
    }

    public List<Ocorrencia> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}
