package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.response.ResponseEtiquetaDTO;
import com.mrdevv.portfolioBackend.models.Etiqueta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEtiquetaService {

    ResponseWithPageable obtenerEtiquetas(Pageable page, String nombre);

    List<Etiqueta> obtenerEtiquetasPorUUIDs(List<String> etiquetaUUIDs);

}
