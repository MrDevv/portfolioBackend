package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.ProfesionalTecnologiaProjection;
import com.mrdevv.portfolioBackend.models.ProfesionalTecnologia;
import com.mrdevv.portfolioBackend.models.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfesionalTecnologiaRepository extends JpaRepository<ProfesionalTecnologia, Long> {

    @Query(value = """
        select
            t.descripcion as descripcion,
            t.logoUrl as logoUrl,
            tt.descripcion as tipoTecnologia,
            pt.nivel as nivel
        from 
        ProfesionalTecnologia pt 
        join pt.tecnologia t
        join t.tipoTecnologia tt 
        join pt.profesional p      
        join p.usuario u 
        where u.usuarioId = :usuario_id
        and (:nombre is null or upper(t.descripcion) like upper(concat(:nombre, '%')))            
    """)
    List<ProfesionalTecnologiaProjection> obtenerTecnologiasDelProfesional(@Param("usuario_id") Long usuarioId, @Param("nombre") String nombre);

    @Query(value = "select count(pt) > 0 from ProfesionalTecnologia pt join pt.profesional p join pt.tecnologia t where t.tecnologiaId = :tecnologia_id and p.profesionalId = :profesional_id")
    boolean existeTecnologiaProfesional(@Param("profesional_id") Long profesionalId, @Param("tecnologia_id") Long tecnologiaId);
}
