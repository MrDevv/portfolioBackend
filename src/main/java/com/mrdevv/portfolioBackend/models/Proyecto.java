package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proyecto_id")
    Long proyectoId;

    String titulo;

    String descripcion;

    String urlProduccion;

    String urlRepositorio;

    Boolean estado;

    @ManyToOne
    @JoinColumn(name = "experiencia_id")
    Experiencia experiencia;

    @ManyToOne
    @JoinColumn(name = "tipo_proyecto_id")
    TipoProyecto tipoProyecto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "proyecto_etiquetas",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    List<Etiqueta> etiqueta;

}
