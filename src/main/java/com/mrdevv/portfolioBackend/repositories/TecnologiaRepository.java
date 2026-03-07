package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long> {
}
