package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.response.ResponseEtiquetaDTO;
import com.mrdevv.portfolioBackend.models.Etiqueta;

import java.util.List;

public interface IEtiquetaService {

    List<ResponseEtiquetaDTO> obtenerEtiquetas();

    List<Etiqueta> obtenerEtiquetasPorUUIDs(List<String> etiquetaUUIDs);

}
