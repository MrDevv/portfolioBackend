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
@Table(name = "profesional_tecnologias")
public class ProfesionalTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesional_tecnologia_id")
    Long profesionalTecnologiaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesional_id")
    Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "tecnologia_id")
    Tecnologia tecnologia;

    String nivel;

}
