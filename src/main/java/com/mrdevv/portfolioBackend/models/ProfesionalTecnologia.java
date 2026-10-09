package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "profesional_tecnologias")
public class ProfesionalTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesional_tecnologia_id")
    Long profesionalTecnologiaId;

    @Column(name = "profesional_tecnologia_uuid", unique = true, nullable = false)
    String profesionalTecnologiaUUID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesional_id")
    Profesional profesional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tecnologia_id")
    Tecnologia tecnologia;

    String nivel;

    @PrePersist
    public void generarUUID() {
        if (profesionalTecnologiaUUID == null) {
            this.profesionalTecnologiaUUID = java.util.UUID.randomUUID().toString();
        }
    }
}
