package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;

public interface IProfesionalService {

    ResponseProfesionalDTO obtenerDatosProfesionalAutenticado();

    ResponseProfesionalDTO actualizarProfesionalAutenticado(UpdateProfesionalDTO updateProfesionalDTO);
}
