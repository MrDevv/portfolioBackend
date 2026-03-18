package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "desarrolladores")
public class Desarrollador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "desarrollador_id")
    Long desarrolladorId;

    String nombres;

    String apellidos;

    String correo;

    @Column(name = "github_url")
    String githubUrl;

    @Column(name = "linkedin_url")
    String linkedinUrl;

    @Column(name = "cv_url")
    String cvUrl;

    @Column(name = "prefijo_telefono")
    String prefijoTelefono;

    String telefono;

    String biografia;

    String puesto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "desarrollador_tecnologias",
            joinColumns = @JoinColumn(name = "desarrollador_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnologia_id")
    )
    List<Tecnologia> tecnologias;

    @OneToOne(mappedBy = "desarrollador")
    Usuario usuario;

}
