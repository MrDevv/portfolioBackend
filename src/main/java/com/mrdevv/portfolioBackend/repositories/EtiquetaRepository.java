package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
