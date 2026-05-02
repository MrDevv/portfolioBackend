package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "tipos_tecnologias")
public class TipoTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_tecnologia_id")
    Long tipoTecnologiaId;

    @Column(name = "tipo_tecnologia_uuid")
    String tipoTecnologiaUUID;

    String descripcion;

}
