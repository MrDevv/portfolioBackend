package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.request.CreateTecnologiaProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateTecnologiaProfesionalDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProfesionalTecnologiaDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface IProfesionalTecnologiaService {

    List<ResponseProfesionalTecnologiaDTO> obtenerTecnologiasProfesionalAutenticado(String nombreTecnologia);

    ResponseProfesionalTecnologiaDTO registrarTecnologiaProfesionalAutenticado(CreateTecnologiaProfesionalDTO tecnologiaProfesionalDTO);

    void eliminarTecnologiaProfesionalAutenticado(String profesionalTecnologiaUUID);

    ResponseProfesionalTecnologiaDTO actualizarTecnologiaProfesionalAutenticado(String profesionalTecnologiaUUID, @Valid UpdateTecnologiaProfesionalDTO tecnologiaProfesionalDTO);

    ResponseProfesionalTecnologiaDTO obtenerTecnologiaProfesionalAutenticado(String profesionalTecnologiaUUID);
}
