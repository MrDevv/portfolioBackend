package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.DesarrolladorProjectionDTO;
import com.mrdevv.portfolioBackend.models.Desarrollador;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {


    @Query("""
    select 
        d.desarrolladorUUID as desarrolladorUUID,
        d.nombres as nombres,
        d.apellidos as apellidos,
        d.correoContacto as correoContacto,
        d.githubUrl as githubUrl,
        d.linkedinUrl as linkedinUrl,
        d.cvUrl as cvUrl,
        d.logoUrl as logoUrl,
        d.prefijoTelefono as prefijoTelefono,
        d.telefono as telefono,
        d.biografia as biografia,
        d.puesto as puesto 
    from Desarrollador d join d.usuario u where u.usuarioId = :usuarioId
    """)
    DesarrolladorProjectionDTO obtenerDesarrolladorPorId(@Param("usuarioId") Long usuarioId);

    @Query("""
    select 
        d.desarrolladorUUID as desarrolladorUUID,
        d.nombres as nombres,
        d.apellidos as apellidos,
        d.correoContacto as correoContacto,
        d.githubUrl as githubUrl,
        d.linkedinUrl as linkedinUrl,
        d.cvUrl as cvUrl,
        d.logoUrl as logoUrl,
        d.prefijoTelefono as prefijoTelefono,
        d.telefono as telefono,
        d.biografia as biografia,
        d.puesto as puesto 
    from Desarrollador d join d.usuario u where (:usuarioId is null or u.usuarioId = :usuarioId) 
    """)
    List<DesarrolladorProjectionDTO> obtenerDesarrolladores(@Param("usuarioId") Long usuarioId);
}
