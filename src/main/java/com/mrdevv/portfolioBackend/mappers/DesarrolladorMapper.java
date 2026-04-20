package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.projection.DesarrolladorProjectionDTO;
import com.mrdevv.portfolioBackend.dto.request.UpdateDesarrolladorDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.models.Desarrollador;

import java.util.List;
import java.util.stream.Collectors;

public class DesarrolladorMapper {

    public static ResponseDesarrolladorDTO toDesarrolladorDTO(DesarrolladorProjectionDTO desarrollador){
        return new ResponseDesarrolladorDTO(
                desarrollador.getDesarrolladorUUID(),
                desarrollador.getNombres(),
                desarrollador.getApellidos(),
                desarrollador.getCorreoContacto(),
                desarrollador.getGithubUrl(),
                desarrollador.getLinkedinUrl(),
                desarrollador.getCvUrl(),
                desarrollador.getLogoUrl(),
                desarrollador.getPrefijoTelefono(),
                desarrollador.getTelefono(),
                desarrollador.getBiografia(),
                desarrollador.getPuesto()
        );
    }

    public static ResponseDesarrolladorDTO toDesarrolladorDTO(Desarrollador desarrollador){
        return new ResponseDesarrolladorDTO(
                desarrollador.getDesarrolladorUUID(),
                desarrollador.getNombres(),
                desarrollador.getApellidos(),
                desarrollador.getCorreoContacto(),
                desarrollador.getGithubUrl(),
                desarrollador.getLinkedinUrl(),
                desarrollador.getCvUrl(),
                desarrollador.getLogoUrl(),
                desarrollador.getPrefijoTelefono(),
                desarrollador.getTelefono(),
                desarrollador.getBiografia(),
                desarrollador.getPuesto()
        );
    }

    public static void updateDesarrollador(Desarrollador desarrollador, UpdateDesarrolladorDTO updateDesarrolladorDTO){
        desarrollador.setNombres(updateDesarrolladorDTO.nombres());
        desarrollador.setApellidos(updateDesarrolladorDTO.apellidos());
        desarrollador.setCorreoContacto(updateDesarrolladorDTO.correoContacto());
        desarrollador.setGithubUrl(updateDesarrolladorDTO.githubUrl());
        desarrollador.setCvUrl(updateDesarrolladorDTO.cvUrl());
        desarrollador.setLogoUrl(updateDesarrolladorDTO.logoUrl());
        desarrollador.setPrefijoTelefono(updateDesarrolladorDTO.prefijoTelefono());
        desarrollador.setTelefono(updateDesarrolladorDTO.telefono());
        desarrollador.setBiografia(updateDesarrolladorDTO.biografia());
        desarrollador.setPuesto(updateDesarrolladorDTO.puesto());
    }

    public static List<ResponseDesarrolladorDTO> toDesarrolladorDTOList(List<DesarrolladorProjectionDTO> desarrolladores){
        return desarrolladores.stream().map(desarrollador -> {
            return new ResponseDesarrolladorDTO(
                    desarrollador.getDesarrolladorUUID(),
                    desarrollador.getNombres(),
                    desarrollador.getApellidos(),
                    desarrollador.getCorreoContacto(),
                    desarrollador.getGithubUrl(),
                    desarrollador.getLinkedinUrl(),
                    desarrollador.getCvUrl(),
                    desarrollador.getLogoUrl(),
                    desarrollador.getPrefijoTelefono(),
                    desarrollador.getTelefono(),
                    desarrollador.getBiografia(),
                    desarrollador.getPuesto()
            );
        }).collect(Collectors.toList());
    }

}
