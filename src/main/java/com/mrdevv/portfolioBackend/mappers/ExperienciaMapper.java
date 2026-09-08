package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.PageableData;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionSimpleDTO;
import com.mrdevv.portfolioBackend.dto.request.CreateExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaCreatedDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciaSimpleDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseExperienciasDTO;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;
import com.mrdevv.portfolioBackend.models.Experiencia;
import com.mrdevv.portfolioBackend.models.Profesional;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ExperienciaMapper {

    public static ResponseWithPageable toResponseExperienciasListDTO(Page<ExperienciaProjectionDTO> experienciasProjection){
        PageableData pageableData = PageableMapper.toPageable(experienciasProjection);

        List<ResponseExperienciasDTO> experienciasDTOS = experienciasProjection.getContent().stream().map(experienciaProjection -> {
            return new ResponseExperienciasDTO(
                    experienciaProjection.experienciaUUID(),
                    experienciaProjection.titulo(),
                    experienciaProjection.descripcion(),
                    experienciaProjection.fechaInicio(),
                    experienciaProjection.fechaFin(),
                    experienciaProjection.nombreEmpresa(),
                    experienciaProjection.puesto(),
                    experienciaProjection.nombres().concat(" ").concat(experienciaProjection.apellidos()),
                    experienciaProjection.cantidadProyectos()
            );
        }).collect(Collectors.toList());

        return new ResponseWithPageable(experienciasDTOS, pageableData);
    }

    public static ResponseExperienciaSimpleDTO toResponseExperienciaSimpleDTO(ExperienciaProjectionSimpleDTO experienciaProjectionDTO){
        return new ResponseExperienciaSimpleDTO(
                experienciaProjectionDTO.getExperienciaUUID(),
                experienciaProjectionDTO.getTitulo()
        );
    }

    public static Experiencia toExperienciaEntity(CreateExperienciaDTO createExperienciaDTO, Long profesionalId) {
        return Experiencia.builder()
                .titulo(createExperienciaDTO.titulo().trim())
                .descripcion(createExperienciaDTO.descripcion().trim())
                .fechaInicio(createExperienciaDTO.fechaInicio())
                .fechaFin(createExperienciaDTO.fechaFin())
                .nombreEmpresa(createExperienciaDTO.nombreEmpresa().trim())
                .puesto(createExperienciaDTO.puesto().trim())
                .profesional(Profesional.builder().profesionalId(profesionalId).build())
                .build();
    }

    public static ResponseExperienciaCreatedDTO toResponseExperienciaCreatedDTO(Experiencia experiencia) {
        return new ResponseExperienciaCreatedDTO(
                experiencia.getExperienciaUUID(),
                experiencia.getTitulo(),
                experiencia.getDescripcion(),
                experiencia.getFechaInicio(),
                experiencia.getFechaFin(),
                experiencia.getNombreEmpresa(),
                experiencia.getPuesto()
        );
    }
}
