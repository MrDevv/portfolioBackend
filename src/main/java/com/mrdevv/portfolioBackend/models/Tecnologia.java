package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "tecnologias")
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tecnologia_id")
    Long tecnologiaId;

    String descripcion;

    @ManyToOne
    @JoinColumn(name = "tipo_tecnologia_id")
    TipoProyecto tipoProyecto;

}
