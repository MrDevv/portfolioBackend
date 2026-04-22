package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.projection.UsuarioProjectionDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseRolDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.response.ResponseUsuarioLoginDTO;
import com.mrdevv.portfolioBackend.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static List<ResponseUsuarioDTO> toResonseUsuarioDTOList(List<UsuarioProjectionDTO> usuarios){
        List<ResponseUsuarioDTO> usuarioDTOS = usuarios.stream()
                .map(usuario -> {
                    String estado = usuario.getEstado() ? "activo" : "inactivo";
                    return new ResponseUsuarioDTO(
                            usuario.getEmail(),
                            usuario.getNombres(),
                            usuario.getApellidos(),
                            usuario.getPuesto(),
                            usuario.getRol(),
                            estado);
        }).collect(Collectors.toList());
        return usuarioDTOS;
    }

//    public static ResponseUsuarioDTO toResponseUsuario(Usuario usuario){
//        return new ResponseUsuarioDTO(
//                usuario.getUsuarioId(),
//                usuario.getEmail(),
//                usuario.getDesarrollador().getNombres(),
//                usuario.getDesarrollador().getApellidos(),
//                usuario.getDesarrollador().getPuesto(),
//                RolMapper.toResponseRolDTO(usuario.getRol()),
//                usuario.getEstado() ? "activo" : "inactivo",
//                usuario.getApiKey()
//                );
//    }

    public static ResponseUsuarioLoginDTO toResponseUsuarioLogin(Usuario usuario, String jwt){
        return new ResponseUsuarioLoginDTO(
                usuario.getUsuarioUUID(),
                usuario.getEmail(),
                usuario.getDesarrollador().getNombres(),
                usuario.getDesarrollador().getApellidos(),
                usuario.getDesarrollador().getPuesto(),
                RolMapper.toResponseRolDTO(usuario.getRol()),
                usuario.getEstado() ? "activo" : "inactivo",
                jwt,
                usuario.getApiKey(),
                usuario.getOrigenPermitido(),
                usuario.getEstadoOrigen() ? "activo" : "inactivo"
        );
    }

}
