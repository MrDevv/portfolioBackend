package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {

    @Query(value = "select r from Rol r where r.descripcion = :descripcion")
    Optional<Rol> buscarRolPorDescripcion(@Param("descripcion") String descripcion);

}
