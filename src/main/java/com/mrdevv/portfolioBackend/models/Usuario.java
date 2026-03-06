package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    Long usuarioId;

    String username;

    String password;

    Boolean estado;

    @ManyToOne
    @JoinColumn(name = "desarrollador_id")
    Desarrollador desarrollador;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    Rol rol;

    @Column(name = "api_key")
    String apiKey;

}
