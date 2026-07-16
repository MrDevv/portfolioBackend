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
            "p.apellidos, " +
            "count(pr.proyectoId) cantidadProyectos " +
            "from Experiencia e left join e.proyectos pr join e.profesional p " +
            "join p.usuario u where (:usuario_id is null or u.usuarioId = :usuario_id) " +
            "and (:nombre_empresa is null or lower(e.nombreEmpresa) like concat(lower(:nombre_empresa), '%')) " +
            "group by e.experienciaId, e.descripcion, e.titulo, e.fechaInicio, e.fechaFin, e.nombreEmpresa, e.puesto, p.nombres, p.apellidos " +
            "order by e.fechaInicio desc"
    )
    Page<ExperienciaProjectionDTO> obtenerExperiencias(@Param("usuario_id") Long usuarioId, @Param("nombre_empresa") String nombreEmpresa, Pageable pageable);

}
