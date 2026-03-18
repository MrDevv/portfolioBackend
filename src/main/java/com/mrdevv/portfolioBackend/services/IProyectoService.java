package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.models.Proyecto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProyectoService {

    ResponseWithPageable obtenerProyectos(Long usuarioId, Pageable pageable);

}
