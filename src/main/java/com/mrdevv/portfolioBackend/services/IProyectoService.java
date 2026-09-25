package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.request.CreateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProyectoDTO;
import com.mrdevv.portfolioBackend.models.Proyecto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProyectoService {

    ResponseWithPageable obtenerProyectosProfesionalAutenticado(String titulo, Pageable pageable);

    ResponseWithPageable obtenerProyectosProfesional(Pageable pageable);

    ResponseProyectoDTO crearProyecto(CreateProyectoDTO proyectoDTO);
}
