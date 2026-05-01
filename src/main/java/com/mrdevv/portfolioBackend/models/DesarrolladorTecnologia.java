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
@Table(name = "desarrollador_tecnologias")
public class DesarrolladorTecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "desarrollador_tecnologia_id")
    Long desarrolladorTecnologiaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desarrollador_id")
    Desarrollador desarrollador;

    @ManyToOne
    @JoinColumn(name = "tecnologia_id")
    Tecnologia tecnologia;

    String nivel;

}
