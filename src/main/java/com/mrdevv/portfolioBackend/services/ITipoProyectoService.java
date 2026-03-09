package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.request.CreateTipoProyecto;
import com.mrdevv.portfolioBackend.dto.response.ResponseTipoProyectoDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateTipoProyectoDTO;

import java.util.List;

public interface ITipoProyectoService {

    List<ResponseTipoProyectoDTO> obtenerTiposProyectos();

    ResponseTipoProyectoDTO obtenerTipoProyectoPorId(Long tipoProyectoId);

    ResponseTipoProyectoDTO crearTipoProyecto(CreateTipoProyecto createTipoProyecto);

    ResponseTipoProyectoDTO actualizarTipoProyecto(Long tipoProyectoId, UpdateTipoProyectoDTO updateTipoProyecto);
}
