package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
