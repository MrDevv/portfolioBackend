package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.ResponseDesarrolladorDTO;

import java.util.List;

public interface IDesarrolladorService {

    List<ResponseDesarrolladorDTO> obtenerDesarrolladores();

    ResponseDesarrolladorDTO obtenerDesarrolladorById(Long desarrolladorId);

}
