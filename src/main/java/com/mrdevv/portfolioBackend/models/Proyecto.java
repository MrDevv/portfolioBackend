package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;
import java.util.UUID;

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

    @Column(name = "proyecto_uuid")
    UUID proyectoUUID = UUID.randomUUID();

    String titulo;

    String descripcion;

    String urlProduccion;

    String urlRepositorio;

    String urlImagenPresentacion;

    Boolean estado;

    @ManyToOne
    @JoinColumn(name = "experiencia_id")
    Experiencia experiencia;

    @ManyToOne
    @JoinColumn(name = "tipo_proyecto_id")
    TipoProyecto tipoProyecto;

    @ManyToMany(fetch = FetchType.LAZY)
    @BatchSize(size = 10)
    @JoinTable(
            name = "proyecto_etiquetas",
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    List<Etiqueta> etiquetas;

}
