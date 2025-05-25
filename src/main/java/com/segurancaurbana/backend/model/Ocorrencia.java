package com.segurancaurbana.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ocorrencias")  // Nome da tabela no MySQL
public class Ocorrencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String descricao;
    private String localizacao;
    private String status; // PENDENTE, EM_ANDAMENTO, RESOLVIDO
    
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")  // Chave estrangeira
    private Usuario usuario;
}