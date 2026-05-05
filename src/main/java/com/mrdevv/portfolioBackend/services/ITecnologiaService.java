package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaSimpleDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITecnologiaService {

    ResponseWithPageable obtenerTecnologias(String nombre, Pageable pageable);

    ResponseTecnologiaDTO obtenerTecnologiaPorId(Long tipoProyectoId);

}
