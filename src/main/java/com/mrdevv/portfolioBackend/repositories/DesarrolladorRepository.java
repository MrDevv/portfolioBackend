package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Desarrollador;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {

    @EntityGraph(attributePaths = {"usuario"})
    @Query("""
        select d from Desarrollador d join d.usuario u where u.apiKey = :apiKey
    """)
    Desarrollador obtenerDesarrolladorPorApiKey(@Param("apiKey") String apiKey);

}
