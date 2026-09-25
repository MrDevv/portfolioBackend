package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {

    @Query("SELECT e FROM Etiqueta e WHERE e.etiquetaUUID IN :etiquetaUUIDs")
    List<Etiqueta> findAllByEtiquetaUUIDIn(List<String> etiquetaUUIDs);
}
