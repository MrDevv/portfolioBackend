package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.request.UpdateExperienceDTO;
import com.mrdevv.portfolioBackend.dto.PageableData;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionSimpleDTO;
import com.mrdevv.portfolioBackend.dto.request.CreateExperienciaDTO;
import com.mrdevv.portfolioBackend.dto.response.*;
import com.mrdevv.portfolioBackend.dto.projection.ExperienciaProjectionDTO;
import com.mrdevv.portfolioBackend.models.Experiencia;
import com.mrdevv.portfolioBackend.models.Profesional;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ExperienciaMapper {

    public static ResponseWithPageable toResponseExperienciasListDTO(Page<ExperienciaProjectionDTO> experienciasProjection){
        PageableData pageableData = PageableMapper.toPageable(experienciasProjection);

        List<ResponseExperienciaDetailDTO> experienciasDTOS = experienciasProjection.getContent().stream().map(experienciaProjection -> {
            return new ResponseExperienciaDetailDTO(
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

    public static void actualizarExperienciaEntity(Experiencia experiencia, UpdateExperienceDTO updateExperienceDTO) {
        experiencia.setTitulo(updateExperienceDTO.titulo().trim());
        experiencia.setDescripcion(updateExperienceDTO.descripcion().trim());
        experiencia.setFechaInicio(updateExperienceDTO.fechaInicio());
        experiencia.setFechaFin(updateExperienceDTO.fechaFin());
        experiencia.setNombreEmpresa(updateExperienceDTO.nombreEmpresa().trim());
        experiencia.setPuesto(updateExperienceDTO.puesto().trim());
    }

    public static ResponseExperienciaDTO toResponseExperienciaDTO(Experiencia experiencia) {
        return new ResponseExperienciaDTO(
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
