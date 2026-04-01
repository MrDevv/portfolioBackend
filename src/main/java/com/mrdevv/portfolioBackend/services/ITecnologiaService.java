package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseTecnologiaSimpleDTO;

import java.util.List;

public interface ITecnologiaService {

    List<ResponseTecnologiaDTO> obtenerTecnologias();

    ResponseTecnologiaDTO obtenerTecnologiaPorId(Long tipoProyectoId);

    List<ResponseTecnologiaSimpleDTO> obtenerTecnologiasDesarrollador();

}
