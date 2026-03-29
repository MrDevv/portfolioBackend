package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.request.UpdateDesarrolladorDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseDesarrolladorDTO;
import com.mrdevv.portfolioBackend.models.Desarrollador;

import java.util.List;
import java.util.stream.Collectors;

public class DesarrolladorMapper {

    public static ResponseDesarrolladorDTO toDesarrolladorDTO(Desarrollador desarrollador){
        return new ResponseDesarrolladorDTO(desarrollador.getDesarrolladorId(),
                desarrollador.getNombres(),
                desarrollador.getApellidos(),
                desarrollador.getCorreo(),
                desarrollador.getGithubUrl(),
                desarrollador.getLinkedinUrl(),
                desarrollador.getCvUrl(),
                desarrollador.getPrefijoTelefono(),
                desarrollador.getTelefono(),
                desarrollador.getBiografia(),
                desarrollador.getPuesto()
        );
    }

    public static void updateDesarrollador(Desarrollador desarrollador, UpdateDesarrolladorDTO updateDesarrolladorDTO){
        desarrollador.setNombres(updateDesarrolladorDTO.nombres());
        desarrollador.setApellidos(updateDesarrolladorDTO.apellidos());
        desarrollador.setCorreo(updateDesarrolladorDTO.correo());
        desarrollador.setGithubUrl(updateDesarrolladorDTO.githubUrl());
        desarrollador.setCvUrl(updateDesarrolladorDTO.cvUrl());
        desarrollador.setPrefijoTelefono(updateDesarrolladorDTO.prefijoTelefono());
        desarrollador.setTelefono(updateDesarrolladorDTO.telefono());
        desarrollador.setBiografia(updateDesarrolladorDTO.biografia());
        desarrollador.setPuesto(updateDesarrolladorDTO.puesto());
    }

    public static List<ResponseDesarrolladorDTO> toDesarrolladorDTOList(List<Desarrollador> desarrolladores){
        return desarrolladores.stream().map(desarrollador -> {
            return new ResponseDesarrolladorDTO(desarrollador.getDesarrolladorId(),
                    desarrollador.getNombres(),
                    desarrollador.getApellidos(),
                    desarrollador.getCorreo(),
                    desarrollador.getGithubUrl(),
                    desarrollador.getLinkedinUrl(),
                    desarrollador.getCvUrl(),
                    desarrollador.getPrefijoTelefono(),
                    desarrollador.getTelefono(),
                    desarrollador.getBiografia(),
                    desarrollador.getPuesto()
            );
        }).collect(Collectors.toList());
    }

}
