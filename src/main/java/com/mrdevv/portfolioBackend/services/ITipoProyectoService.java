package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.CreateTipoProyecto;
import com.mrdevv.portfolioBackend.dto.ResponseTipoProyectoDTO;
import com.mrdevv.portfolioBackend.dto.UpdateTipoProyectoDTO;

import java.util.List;

public interface ITipoProyectoService {

    List<ResponseTipoProyectoDTO> obtenerTiposProyectos();

    ResponseTipoProyectoDTO obtenerTipoProyectoPorId(Long tipoProyectoId);

    ResponseTipoProyectoDTO crearTipoProyecto(CreateTipoProyecto createTipoProyecto);

    ResponseTipoProyectoDTO actualizarTipoProyecto(Long tipoProyectoId, UpdateTipoProyectoDTO updateTipoProyecto);
}
