package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.ProfesionalProjectionDTO;
import com.mrdevv.portfolioBackend.models.Profesional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {


    @Query("""
    select 
        p.profesionalUUID as profesionalUUID,
        p.nombres as nombres,
        p.apellidos as apellidos,
        p.correoContacto as correoContacto,
        p.githubUrl as githubUrl,
        p.linkedinUrl as linkedinUrl,
        p.cvUrl as cvUrl,
        p.logoUrl as logoUrl,
        p.prefijoTelefono as prefijoTelefono,
        p.telefono as telefono,
        p.biografia as biografia,
        p.puesto as puesto 
    from Profesional p join p.usuario u where u.usuarioId = :usuarioId
    """)
    ProfesionalProjectionDTO obtenerDatosProfesionalesPorUsuarioId(@Param("usuarioId") Long usuarioId);

    @EntityGraph(attributePaths = {"usuario"})
    @Query(value = "select p from Profesional p join p.usuario u where u.usuarioId = :usuario_id")
    Optional<Profesional> obtenerProfesionalPorUsuarioId(@Param("usuario_id") Long usuarioId);
}
