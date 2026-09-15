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
            "join p.usuario u where (:usuario_id is null or u.usuarioId = :usuario_id) " +
            "and (:nombre_empresa is null or lower(e.nombreEmpresa) like concat(lower(:nombre_empresa), '%')) " +
            "group by e.experienciaUUID, e.descripcion, e.titulo, e.fechaInicio, e.fechaFin, e.nombreEmpresa, e.puesto, p.nombres, p.apellidos " +
            "order by case when e.fechaFin is null then 0 else 1 end asc, e.fechaFin desc"
    )
    Page<ExperienciaProjectionDTO> obtenerExperiencias(@Param("usuario_id") Long usuarioId, @Param("nombre_empresa") String nombreEmpresa, Pageable pageable);

    @Query(value = "select " +
            "e " +
            "from Experiencia e join e.profesional p join p.usuario u " +
            "where e.experienciaUUID = :experiencia_uuid and u.usuarioId = :usuario_id")
    Optional<ExperienciaConProyectosProjectionDTO> obtenerDetalleExperiencia(@Param("usuario_id") Long usuarioId, @Param("experiencia_uuid") String experienciaUUID);

    @Query(value = "select count(e) > 0 from Experiencia e join e.profesional p join p.usuario u where lower(e.titulo) = lower(:experiencia_titulo) and u.usuarioId = :usuario_id")
    boolean existeExperienciaProfesional(@Param("usuario_id") Long usuarioId, @Param("experiencia_titulo") String experienciaTitulo);

    @Query(value = "select e from Experiencia e join e.profesional p join p.usuario u where e.experienciaUUID = :experiencia_uuid and u.usuarioId = :usuario_id")
    Optional<Experiencia> obtenerExperienciaPorUUIDyUsuarioId(@Param("usuario_id") Long usuarioId, @Param("experiencia_uuid") String experienciaUUID);
}
