package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.dto.projection.DesarrolladorTecnologiaProjection;
import com.mrdevv.portfolioBackend.models.DesarrolladorTecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesarrolladorTecnologiaRepository extends JpaRepository<DesarrolladorTecnologia, Long> {

    @Query(value = """
        select
            t.descripcion as descripcion,
            t.logoUrl as logoUrl,
            tt.descripcion as tipoTecnologia,
            dt.nivel as nivel
        from 
        DesarrolladorTecnologia dt 
        join dt.tecnologia t
        join t.tipoTecnologia tt 
        join dt.desarrollador d         
        join d.usuario u 
        where u.usuarioId = :usuario_id
        and (:nombre is null or upper(t.descripcion) like upper(concat(:nombre, '%')))            
    """)
    List<DesarrolladorTecnologiaProjection> obtenerTecnologiasDelDesarrollador(@Param("usuario_id") Long usuarioId, @Param("nombre") String nombre);
}
