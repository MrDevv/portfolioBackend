package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;
import com.mrdevv.portfolioBackend.models.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

    @Query(value = "select " +
            "e.experienciaId, " +
            "e.descripcion, " +
            "e.titulo, " +
            "e.fechaInicio, " +
            "e.fechaFin, " +
            "e.nombreEmpresa, " +
            "d.nombres, " +
            "d.apellidos " +
            "from Experiencia e join e.desarrollador d")
    List<ExperienciaProjectionDTO> obtenerExperiencias();

}
