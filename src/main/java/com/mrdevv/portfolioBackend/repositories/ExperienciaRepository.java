package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.ExperienciaConProyectosProjectionDTO;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;
import com.mrdevv.portfolioBackend.models.Experiencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

    @Query(value = "select " +
            "e.experienciaUUID, " +
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
            "where (:profesional_id is null or p.profesionalId = :profesional_id) " +
            "and lower(e.nombreEmpresa) like concat(:nombre_empresa, '%') " +
            "group by e.experienciaUUID, e.descripcion, e.titulo, e.fechaInicio, e.fechaFin, e.nombreEmpresa, e.puesto, p.nombres, p.apellidos " +
            "order by case when e.fechaFin is null then 0 else 1 end asc, e.fechaFin desc"
    )
    Page<ExperienciaProjectionDTO> obtenerExperiencias(@Param("profesional_id") Long profesionalId, @Param("nombre_empresa") String nombreEmpresa, Pageable pageable);

    @Query(value = "select " +
            "e " +
            "from Experiencia e join e.profesional p " +
            "where e.experienciaUUID = :experiencia_uuid and p.profesionalId = :profesional_id")
    Optional<ExperienciaConProyectosProjectionDTO> obtenerDetalleExperiencia(@Param("profesional_id") Long profesionalId, @Param("experiencia_uuid") String experienciaUUID);

//    Valida si existe una experiencia con el mismo titulo para un profesional especifico
    @Query(value = "select count(e) > 0 from Experiencia e join e.profesional p where lower(e.titulo) = lower(:experiencia_titulo) and p.profesionalId = :profesional_id")
    boolean existeExperienciaEnProfesional(@Param("profesional_id") Long profesionalId, @Param("experiencia_titulo") String experienciaTitulo);

    @Query(value = "select e from Experiencia e join e.profesional p where e.experienciaUUID = :experiencia_uuid and p.profesionalId = :profesional_id")
    Optional<Experiencia> obtenerExperienciaPorUUIDyProfesionalId(@Param("profesional_id") Long profesionalId, @Param("experiencia_uuid") String experienciaUUID);
}
