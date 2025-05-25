package com.segurancaurbana.backend.model;  // Note o pacote correto!

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")  // Nome da tabela no MySQL
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    private String senha;
    private String tipoUsuario; // Valores: CIDADAO, AGENTE_PUBLICO, ADMIN
}