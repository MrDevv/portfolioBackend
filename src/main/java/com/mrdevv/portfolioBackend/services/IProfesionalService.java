package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.request.UpdateProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalDTO;
import com.mrdevv.portfolioBackend.models.Profesional;

public interface IProfesionalService {

    ResponseProfesionalDTO obtenerDatosProfesionalAutenticado();

    ResponseProfesionalDTO actualizarProfesionalAutenticado(UpdateProfesionalDTO updateProfesionalDTO);

    Profesional obtenerProfesionalPorUsuarioId(Long usuarioId);
}
