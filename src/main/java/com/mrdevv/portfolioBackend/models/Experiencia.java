package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "experiencias")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experiencia_id")
    Long experienciaId;

    String descripcion;

    String titulo;

    @Column(name = "fecha_inicio")
    LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    LocalDate fechaFin;

    @Column(name = "nombre_empresa")
    String nombreEmpresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desarrollador_id")
    Desarrollador desarrollador;
}
