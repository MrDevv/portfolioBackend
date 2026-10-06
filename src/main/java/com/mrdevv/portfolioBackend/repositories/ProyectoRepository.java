package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.ProyectoProjectionDTO;
import com.mrdevv.portfolioBackend.models.Proyecto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    @EntityGraph(attributePaths = {
            "experiencia",
            "tipoProyecto"
    })
    @Query(value = """
        select p
        from Proyecto p
        join p.experiencia e
        join e.profesional pr
        where (:profesional_id is null or pr.profesionalId = :profesional_id)
        and lower(p.titulo) like concat('%', :titulo, '%')
        order by p.proyectoId desc
    """)
    Page<ProyectoProjectionDTO> obtenerProyectos(@Param(value = "profesional_id") Long profesionalId,
                                                 @Param(value = "titulo") String titulo,
                                                 Pageable pageable);

    @Query(value = "select count(p) > 0 from Proyecto p join p.experiencia e where lower(p.titulo) = lower(:titulo) and e.experienciaUUID = :experiencia_uuid")
    boolean existeProyectoEnExperiencia(@Param(value = "titulo") String titulo, @Param(value = "experiencia_uuid") String experienciaUUID);


    @Query(value = "select p from Proyecto p join p.experiencia e where p.proyectoUUID = :proyecto_uuid and e.profesional.profesionalId = :profesional_id")
    Optional<Proyecto> obtenerProyectoPorUUIDyProfesionalId(@Param(value = "proyecto_uuid") String proyectoUUID, @Param(value = "profesional_id") Long profesionalId);
}
