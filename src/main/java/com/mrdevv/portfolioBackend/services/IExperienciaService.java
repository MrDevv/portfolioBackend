package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaCreatedDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExperienciaService {

    ResponseWithPageable obtenerExperienciasProfesionalAutenticado(String nombreEmpresa, Pageable pageable);

    ResponseExperienciaCreatedDTO registrarExperienciaProfesionalAutenticado(@Valid CreateExperienciaDTO createExperienciaDTO);
}
