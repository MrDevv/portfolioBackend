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
            "d.nombres, " +
            "d.apellidos " +
            "from Experiencia e join e.desarrollador d " +
            "join d.usuario u where (:apiKey is null or u.apiKey = :apiKey)"
    )
    Page<ExperienciaProjectionDTO> obtenerExperiencias(@Param("apiKey") String apiKey, Pageable pageable);

}
