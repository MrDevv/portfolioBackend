package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;

import java.util.List;

public interface IExperienciaService {

    List<ResponseExperienciasDTO> obtenerExperiencias();

}
