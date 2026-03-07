package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.ResponseTecnologiaDTO;
import com.mrdevv.portfolioBackend.dto.ResponseTecnologiaSimpleDTO;
import com.mrdevv.portfolioBackend.models.Tecnologia;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TecnologiaMapper {

    public static List<ResponseTecnologiaDTO> toResponseTecnologiaDTOList(List<Tecnologia> tecnologias){
        return tecnologias.stream().map(tecnologia -> {
            return new ResponseTecnologiaDTO(
                    tecnologia.getTecnologiaId(),
                    tecnologia.getDescripcion(),
                    TipoProyectoMapper.toResponseTipoProyectoDTO(tecnologia.getTipoProyecto()));
        }).collect(Collectors.toList());
    }

    public static ResponseTecnologiaDTO toResponseTecnologiaDTO(Tecnologia tecnologia){
        return new ResponseTecnologiaDTO(
                tecnologia.getTecnologiaId(),
                tecnologia.getDescripcion(),
                TipoProyectoMapper.toResponseTipoProyectoDTO(tecnologia.getTipoProyecto()));
    }

    public static List<ResponseTecnologiaSimpleDTO> toResponseTecnologiaSimpleDTOList(List<Tecnologia> tecnologias){
        return tecnologias.stream().map(tecnologia -> {
            return new ResponseTecnologiaSimpleDTO(
                    tecnologia.getTecnologiaId(),
                    tecnologia.getDescripcion(),
                    tecnologia.getTipoProyecto().getDescripcion());
        }).collect(Collectors.toList());
    }
}
