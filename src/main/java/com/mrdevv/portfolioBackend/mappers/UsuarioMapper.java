package com.mrdevv.portfolioBackend.mappers;

import com.mrdevv.portfolioBackend.dto.ResponseRolDTO;
import com.mrdevv.portfolioBackend.dto.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static List<ResponseUsuarioDTO> toResonseUsuarioDTOList(List<Object[]> usuarios){
        List<ResponseUsuarioDTO> usuarioDTOS = usuarios.stream()
                .map(usuario -> {
                    Long usuarioId = ((Number) usuario[0]).longValue();
                    String username = usuario[1].toString();
                    String nombres = usuario[2].toString();
                    String apellidos = usuario[3].toString();
                    String puesto = usuario[4].toString();
                    Long rolId = ((Number) usuario[5]).longValue();
                    String rol = usuario[6].toString();
                    String estado = Boolean.parseBoolean(usuario[7].toString()) ? "activo" : "inactivo";
                    String tokenAccesoFront = usuario[8] != null ? usuario[8].toString() : null;

                    return new ResponseUsuarioDTO(usuarioId, username, nombres, apellidos, puesto, new ResponseRolDTO(rolId, rol), estado, tokenAccesoFront);
        }).collect(Collectors.toList());

        return usuarioDTOS;
    }

    public static ResponseUsuarioDTO toResponseUsuario(Usuario usuario){
        return new ResponseUsuarioDTO(
                usuario.getUsuarioId(),
                usuario.getUsername(),
                usuario.getDesarrollador().getNombres(),
                usuario.getDesarrollador().getApellidos(),
                usuario.getDesarrollador().getPuesto(),
                RolMapper.toResponseRolDTO(usuario.getRol()),
                usuario.getEstado() ? "activo" : "inactivo",
                usuario.getTokenAccesoFront()
                );
    }

}
