package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {
}
