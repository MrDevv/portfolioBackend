package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.TipoProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProyectoRepository extends JpaRepository<TipoProyecto, Long> {
}
