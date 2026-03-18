package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionSimpleDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaSimpleDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ExperienciaMapper {

    public static List<ResponseExperienciasDTO> toResponseExperienciasListDTO(List<ExperienciaProjectionDTO> experienciasProjection){
        return experienciasProjection.stream().map(experienciaProjection -> {
            return new ResponseExperienciasDTO(
                    experienciaProjection.experienciaId(),
                    experienciaProjection.titulo(),
                    experienciaProjection.descripcion(),
                    experienciaProjection.fechaInicio(),
                    experienciaProjection.fechaFin(),
                    experienciaProjection.nombreEmpresa(),
                    experienciaProjection.nombres().concat(" ").concat(experienciaProjection.apellidos())
            );
        }).collect(Collectors.toList());
    }

    public static ResponseExperienciaSimpleDTO toResponseExperienciaSimpleDTO(ExperienciaProjectionSimpleDTO experienciaProjectionDTO){
        return new ResponseExperienciaSimpleDTO(
                experienciaProjectionDTO.getExperienciaId(),
                experienciaProjectionDTO.getDescripcion()
        );
    }

}
