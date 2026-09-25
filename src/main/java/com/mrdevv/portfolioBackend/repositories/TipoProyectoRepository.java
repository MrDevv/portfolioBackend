package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.TipoProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoProyectoRepository extends JpaRepository<TipoProyecto, Long> {

    @Query("SELECT tp FROM TipoProyecto tp WHERE tp.tipoProyectoUUID = :tipoProyectoUUID")
    Optional<TipoProyecto> obtenerTipoProyectoPorUUID(String tipoProyectoUUID);
}
