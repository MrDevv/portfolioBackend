package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorTecnologia;
import com.mrdevv.portfolioBackend.models.DesarrolladorTecnologia;

import java.util.List;

public interface IDesarrolladorTecnologiaService {

    List<ResponseDesarrolladorTecnologia> obtenerTecnologiasDesarrollador();
}
