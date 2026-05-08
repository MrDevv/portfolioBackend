package com.mrdevv.portfolioBackend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "profesionales")
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesional_id")
    Long profesionalId;

    @Column(name = "profesional_uuid")
    String profesionalUUID;

    String nombres;

    String apellidos;

    @Column(name = "correo_contacto")
    String correoContacto;

    @Column(name = "github_url")
    String githubUrl;

    @Column(name = "linkedin_url")
    String linkedinUrl;

    @Column(name = "cv_url")
    String cvUrl;

    @Column(name = "logo_url")
    String logoUrl;

    @Column(name = "prefijo_telefono")
    String prefijoTelefono;

    String telefono;

    String biografia;

    String puesto;

    @OneToOne(mappedBy = "profesional")
    Usuario usuario;

    @PrePersist
    void generarUUID(){
        if (this.profesionalUUID == null){
            this.profesionalUUID = UUID.randomUUID().toString();
        }
    }

}
