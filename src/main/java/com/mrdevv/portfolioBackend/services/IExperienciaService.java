package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.request.UpdateExperienceDTO;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.*;
import com.mrdevv.portfolioBackend.models.Experiencia;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IExperienciaService {

    ResponseWithPageable obtenerExperienciasProfesionalAutenticado(String nombreEmpresa, Pageable pageable);

    ResponseExperienciaDTO obtenerExperienciaProfesionalAutenticado(String experienciaUUID);

    Experiencia obtenerExperienciaPorUUIDyProfesionalId(Long profesionalId, String experienciaUUID);

    ResponseExperienciaDTO registrarExperienciaProfesionalAutenticado(@Valid CreateExperienciaDTO createExperienciaDTO);

    ResponseExperienciaDTO actualizarExperienciaProfesionalAutenticada(@Valid UpdateExperienceDTO updateExperienceDTO, String experienciaUUID);

    void eliminarExperienciaProfesionalAutenticado(String experienciaUUID);

    ResponseExperienciaConProyectosDTO obtenerExperienciaConProyectosProfesionalAutenticado(String experienciaUUID);

}
