package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.response.ResponseTipoProyectoDTO;
import com.mrdevv.portfolioBackend.models.TipoProyecto;

import java.util.List;
import java.util.stream.Collectors;

public class TipoProyectoMapper {

    public static List<ResponseTipoProyectoDTO> toResponseTipoProyectoDTOList(List<TipoProyecto> tipoProyectos){
        return tipoProyectos.stream().map(tipoProyecto -> new ResponseTipoProyectoDTO(
                tipoProyecto.getTipoProyectoId(),
                tipoProyecto.getDescripcion())
                ).collect(Collectors.toList()
        );
    }

    public static ResponseTipoProyectoDTO toResponseTipoProyectoDTO(TipoProyecto tipoProyecto){
        return new ResponseTipoProyectoDTO(
                tipoProyecto.getTipoProyectoId(),
                tipoProyecto.getDescripcion()
        );
    }

}
