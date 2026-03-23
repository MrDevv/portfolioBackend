package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.PageableData;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionSimpleDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaSimpleDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ExperienciaMapper {

    public static ResponseWithPageable toResponseExperienciasListDTO(Page<ExperienciaProjectionDTO> experienciasProjection){
        PageableData pageableData = PageableMapper.toPageable(experienciasProjection);

        List<ResponseExperienciasDTO> experienciasDTOS = experienciasProjection.getContent().stream().map(experienciaProjection -> {
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

        return new ResponseWithPageable(experienciasDTOS, pageableData);
    }

    public static ResponseExperienciaSimpleDTO toResponseExperienciaSimpleDTO(ExperienciaProjectionSimpleDTO experienciaProjectionDTO){
        return new ResponseExperienciaSimpleDTO(
                experienciaProjectionDTO.getExperienciaId(),
                experienciaProjectionDTO.getDescripcion()
        );
    }

}
