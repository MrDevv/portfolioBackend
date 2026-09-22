package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "tipos_proyectos")
public class TipoProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_proyecto_id")
    Long tipoProyectoId;

    @Column(name = "tipo_proyecto_uuid")
    String tipoProyectoUUID;

    String descripcion;

    @PrePersist
    void generarUUID(){
        if (this.tipoProyectoUUID == null){
            this.tipoProyectoUUID = UUID.randomUUID().toString();
        }
    }
}
