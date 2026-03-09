package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.response.ResponseEtiquetaDTO;

import java.util.List;

public interface IEtiquetaService {

    List<ResponseEtiquetaDTO> obtenerEtiquetas();

}
