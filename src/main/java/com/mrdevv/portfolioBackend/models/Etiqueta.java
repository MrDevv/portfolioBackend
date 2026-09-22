package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "etiquetas")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etiqueta_id")
    Long etiquetaId;

    @Column(name = "etiqueta_uuid")
    String etiquetaUUID;

    String descripcion;

    @PrePersist
    void generarUUID(){
        if (this.etiquetaUUID == null){
            this.etiquetaUUID = UUID.randomUUID().toString();
        }
    }

}
