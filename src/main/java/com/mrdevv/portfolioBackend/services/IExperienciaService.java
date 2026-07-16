package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExperienciaService {

    ResponseWithPageable obtenerExperienciasProfesionalAutenticado(String nombreEmpresa, Pageable pageable);

}
