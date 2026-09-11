package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.request.UpdateExperienceDTO;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaCreatedDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaUpdatedDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaDetailDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;

public interface IExperienciaService {

    ResponseWithPageable obtenerExperienciasProfesionalAutenticado(String nombreEmpresa, Pageable pageable);

    ResponseExperienciaDTO obtenerExperienciaProfesionalAutenticado(String experienciaUUID);

    ResponseExperienciaDTO registrarExperienciaProfesionalAutenticado(@Valid CreateExperienciaDTO createExperienciaDTO);

    ResponseExperienciaDTO actualizarExperienciaProfesionalAutenticada(@Valid UpdateExperienceDTO updateExperienceDTO, String experienciaUUID);
}
