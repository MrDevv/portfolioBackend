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

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    @EntityGraph(attributePaths = {
            "experiencia",
            "tipoProyecto",
            "etiquetas"
    })
    @Query(value = """
        select p
        from Proyecto p
        join p.experiencia e
        join e.desarrollador d
        join d.usuario u
        where (:api_key is null or u.apiKey = :api_key)
        and (:usuario_id is null or u.usuarioId = :usuario_id)
    """)
    Page<ProyectoProjectionDTO> obtenerProyectos(@Param(value = "api_key") String apiKey,
                                                @Param(value = "usuario_id") Long usuarioId,
                                                 Pageable pageable);


}
