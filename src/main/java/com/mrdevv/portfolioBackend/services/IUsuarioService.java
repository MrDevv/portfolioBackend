package com.mrdevv.portfolioBackend.services;

import com.mrdevv.portfolioBackend.dto.ResponseApiKeyUsuario;
import com.mrdevv.portfolioBackend.dto.ResponseUsuarioDTO;
import com.mrdevv.portfolioBackend.dto.UpdateRolUsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    List<ResponseUsuarioDTO> obtenerUsuarios();

    ResponseUsuarioDTO obtenerUsuario(Long usuarioId);

    void actualizarRol(Long usuarioId, UpdateRolUsuarioDTO rol);

    ResponseApiKeyUsuario generarApiKey(Long usuarioId);
}
