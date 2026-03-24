package com.mrdevv.portfolioBackend.repositories;

import com.mrdevv.portfolioBackend.models.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Long> {

    @Query(value = """
        select t, tp
        from Desarrollador d 
        join d.usuario u
        join d.tecnologias t
        join t.tipoProyecto tp
        where (:api_key is null or u.apiKey = :api_key)        
    """)
    List<Tecnologia> obtenerTecnologias(@Param(value = "api_key") String apiKey);

}
