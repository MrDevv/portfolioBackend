package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.response.ResponseTipoProyectoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseTipoTecnologiaDTO;
import com.mrdevv.portfolioBackend.models.TipoProyecto;
import com.mrdevv.portfolioBackend.models.TipoTecnologia;

import java.util.List;
import java.util.stream.Collectors;

public class TipoTecnologiaMapper {

    private TipoTecnologiaMapper(){};

    public static List<ResponseTipoTecnologiaDTO> toResponseTipoTecnologiaDTOList(List<TipoTecnologia> tipoTecnologias){
        return tipoTecnologias.stream().map(tipoTecnologia -> new ResponseTipoTecnologiaDTO(
                tipoTecnologia.getTipoTecnologiaUUID(),
                tipoTecnologia.getDescripcion())
        ).collect(Collectors.toList());
    }

    public static ResponseTipoTecnologiaDTO toResponseTipoTecnologiaDTO(TipoTecnologia tipoTecnologia){
        return new ResponseTipoTecnologiaDTO(
                tipoTecnologia.getTipoTecnologiaUUID(),
                tipoTecnologia.getDescripcion());
    }
}
