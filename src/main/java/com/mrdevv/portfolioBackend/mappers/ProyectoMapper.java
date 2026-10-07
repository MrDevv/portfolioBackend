package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.PageableData;
import com.mrdevv.portfolioBackend.dto.ResponseWithPageable;
import com.mrdevv.portfolioBackend.dto.projection.ProyectoProjectionDTO;
import com.mrdevv.portfolioBackend.dto.projection.ProyectoSinExperienciaProjectionDTO;
import com.mrdevv.portfolioBackend.dto.request.CreateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateProyectoDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseProyectoDTO;
import com.mrdevv.portfolioBackend.models.Etiqueta;
import com.mrdevv.portfolioBackend.models.Experiencia;
import com.mrdevv.portfolioBackend.models.Proyecto;
import com.mrdevv.portfolioBackend.models.TipoProyecto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ProyectoMapper {

    private ProyectoMapper(){};

    public static ResponseWithPageable toResponseProyectoListDTO(Page<ProyectoProjectionDTO> proyectoProjectionDTOS){
        List<ProyectoProjectionDTO> proyectoProjectionList =  proyectoProjectionDTOS.getContent();
        PageableData pageableData = PageableMapper.toPageable(proyectoProjectionDTOS);

        List<ResponseProyectoDTO> proyectosListDTO = proyectoProjectionList.stream().map(proyecto -> {
            return new ResponseProyectoDTO(
                proyecto.getProyectoUUID(),
                proyecto.getTitulo(),
                    proyecto.getDescripcion(),
                    proyecto.getUrlProduccion(),
                    proyecto.getUrlRepositorio(),
                    proyecto.getUrlImagenPresentacion(),
                    proyecto.getEstado() ? "activo" : "inactivo",
                    ExperienciaMapper.toResponseExperienciaSimpleDTO(proyecto.getExperiencia()),
                    TipoProyectoMapper.toResponseTipoProyectoDTO(proyecto.getTipoProyecto()),
                    EtiquetaMapper.toEtiquetaListDTO(proyecto.getEtiquetas())
            );
        }).collect(Collectors.toList());

        return new ResponseWithPageable(proyectosListDTO, pageableData);

    }

    public static List<ResponseProyectoDTO> toResponseProyectoListDTO(List<ProyectoSinExperienciaProjectionDTO> proyectoProjectionDTOS){
        return proyectoProjectionDTOS.stream().map(proyectoProjectionDTO -> new ResponseProyectoDTO(
                proyectoProjectionDTO.getProyectoUUID(),
                proyectoProjectionDTO.getTitulo(),
                proyectoProjectionDTO.getDescripcion(),
                proyectoProjectionDTO.getUrlProduccion(),
                proyectoProjectionDTO.getUrlRepositorio(),
                proyectoProjectionDTO.getUrlImagenPresentacion(),
                proyectoProjectionDTO.getEstado() ? "activo" : "inactivo",
                null,
                TipoProyectoMapper.toResponseTipoProyectoDTO(proyectoProjectionDTO.getTipoProyecto()),
                EtiquetaMapper.toEtiquetaListDTO(proyectoProjectionDTO.getEtiquetas())
        )).toList();
    }

    public static ResponseProyectoDTO toResponseProyectoDTO(Proyecto proyecto){
        return new ResponseProyectoDTO(
                proyecto.getProyectoUUID(),
                proyecto.getTitulo(),
                proyecto.getDescripcion(),
                proyecto.getUrlProduccion(),
                proyecto.getUrlRepositorio(),
                proyecto.getUrlImagenPresentacion(),
                proyecto.getEstado() ? "activo" : "inactivo",
                ExperienciaMapper.toResponseExperienciaSimpleDTO(proyecto.getExperiencia()),
                TipoProyectoMapper.toResponseTipoProyectoDTO(proyecto.getTipoProyecto()),
                EtiquetaMapper.toEtiquetaListDTOFromEntity(proyecto.getEtiquetas())
        );
    }

    public static Proyecto toProyectoEntity(CreateProyectoDTO proyectoDTO, Experiencia experiencia,  TipoProyecto tipoProyecto, List<Etiqueta> etiquetas) {
        return Proyecto.builder()
                .titulo(proyectoDTO.titulo())
                .descripcion(proyectoDTO.descripcion())
                .urlProduccion(proyectoDTO.urlProduccion())
                .urlRepositorio(proyectoDTO.urlRepositorio())
                .urlImagenPresentacion(proyectoDTO.urlImagenPresentacion())
                .experiencia(experiencia)
                .tipoProyecto(tipoProyecto)
                .etiquetas(etiquetas)
                .build();
    }

    public static void actualizarProyecto(Proyecto proyecto, Experiencia experiencia, TipoProyecto tipoProyecto, List<Etiqueta> etiquetas, UpdateProyectoDTO proyectoDTO) {
        proyecto.setTitulo(proyectoDTO.titulo());
        proyecto.setDescripcion(proyectoDTO.descripcion());
        proyecto.setUrlProduccion(proyectoDTO.urlProduccion());
        proyecto.setUrlRepositorio(proyectoDTO.urlRepositorio());
        proyecto.setUrlImagenPresentacion(proyectoDTO.urlImagenPresentacion());
        proyecto.setExperiencia(experiencia);
        proyecto.setTipoProyecto(tipoProyecto);
        proyecto.setEtiquetas(etiquetas);
    }

    public static ResponseProyectoDTO toResponseProyectoDTO(ProyectoProjectionDTO proyectoProjection) {
        return new ResponseProyectoDTO(
                proyectoProjection.getProyectoUUID(),
                proyectoProjection.getTitulo(),
                proyectoProjection.getDescripcion(),
                proyectoProjection.getUrlProduccion(),
                proyectoProjection.getUrlRepositorio(),
                proyectoProjection.getUrlImagenPresentacion(),
                proyectoProjection.getEstado() ? "activo" : "inactivo",
                ExperienciaMapper.toResponseExperienciaSimpleDTO(proyectoProjection.getExperiencia()),
                TipoProyectoMapper.toResponseTipoProyectoDTO(proyectoProjection.getTipoProyecto()),
                EtiquetaMapper.toEtiquetaListDTO(proyectoProjection.getEtiquetas())
        );
    }
}
