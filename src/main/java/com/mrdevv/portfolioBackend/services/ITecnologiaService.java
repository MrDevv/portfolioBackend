package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.ResponseTecnologiaDTO;

import java.util.List;

public interface ITecnologiaService {

    List<ResponseTecnologiaDTO> obtenerTecnologias();

    ResponseTecnologiaDTO obtenerTecnologiaPorId(Long tipoProyectoId);

}
