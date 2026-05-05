package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;
import com.mrdevv.portfolioBackend.models.Experiencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

    @Query(value = "select " +
            "e.experienciaId, " +
            "e.descripcion, " +
            "e.titulo, " +
            "e.fechaInicio, " +
            "e.fechaFin, " +
            "e.nombreEmpresa, " +
            "e.puesto, " +
            "p.nombres, " +
            "p.apellidos " +
            "from Experiencia e join e.profesional p " +
            "join p.usuario u where (:usuario_id is null or u.usuarioId = :usuario_id) order by e.fechaInicio desc"
    )
    Page<ExperienciaProjectionDTO> obtenerExperiencias(@Param("usuario_id") Long usuarioId, Pageable pageable);

}
