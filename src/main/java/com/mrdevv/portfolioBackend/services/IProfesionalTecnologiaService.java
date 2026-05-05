package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;

import java.util.List;

public interface IProfesionalTecnologiaService {

    List<ResponseProfesionalTecnologiaDTO> obtenerTecnologiasProfesionalAutenticado(String nombreTecnologia);
}
