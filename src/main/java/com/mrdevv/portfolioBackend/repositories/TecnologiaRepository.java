package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long> {

}
