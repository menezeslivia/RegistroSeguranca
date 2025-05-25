package com.segurancaurbana.backend.controller;

import com.segurancaurbana.backend.model.Ocorrencia;
import com.segurancaurbana.backend.model.Usuario;
import com.segurancaurbana.backend.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService service;

    @PostMapping
    public ResponseEntity<Ocorrencia> criar(@RequestBody Ocorrencia ocorrencia, @RequestParam Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId); // Simulação de um usuário

        Ocorrencia novaOcorrencia = service.criarOcorrencia(ocorrencia, usuario);
        return ResponseEntity.ok(novaOcorrencia);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Ocorrencia>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<Ocorrencia> ocorrencias = service.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(ocorrencias);
    }
}
